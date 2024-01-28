import { Injectable } from '@angular/core';
import axios, { AxiosRequestConfig, Method } from 'axios';

@Injectable({
  providedIn: 'root'
})
export class AxiosService {

  constructor() {
    axios.defaults.baseURL = 'http://localhost:8081/api/v1/auth';
  }

  request(method: Method, url: string, data: any): Promise<any> {

    console.log("data", data);
    return axios({
      method: method,
      url: url,
      data: data
    });
  }
}
