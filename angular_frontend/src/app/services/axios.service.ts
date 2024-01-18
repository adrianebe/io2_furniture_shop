import { Injectable } from '@angular/core';
import axios, { AxiosRequestConfig, Method } from 'axios';

@Injectable({
  providedIn: 'root'
})
export class AxiosService {

  constructor() {
    axios.defaults.baseURL = 'http://localhost:8080/api/v1/auth';
    axios.defaults.headers.post['Content-Type'] = 'application/json';
  }

  getAuthToken(): string | null {
    console.log("getAuthToken")
    return window.localStorage.getItem("auth_token");
  }

  setAuthToken(token: string | null): void {
    console.log('Ustawianie tokena:', token);

    if (token !== null) {
      window.localStorage.setItem("auth_token", token);
    } else {
      window.localStorage.removeItem("auth_token");
    }
  }

  request(method: Method, url: string, data: any): Promise<any> {
    let headers: any = {};

    if (this.getAuthToken() !== null) {
      headers = {"Authorization": "Bearer " + this.getAuthToken()};
    }
    console.log(headers);
    console.log(localStorage);
    return axios({
      method: method,
      url: url,
      data: data,
      headers: headers
    });

  }


}
