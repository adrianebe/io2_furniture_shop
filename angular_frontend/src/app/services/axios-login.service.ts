import { Injectable } from '@angular/core';
import axios, { AxiosRequestConfig, Method } from 'axios';

@Injectable({
  providedIn: 'root'
})
export class AxiosLoginService {

  constructor() {
    axios.defaults.baseURL = 'http://localhost:8080/api/v1/auth';
  }

  request(method: Method, url: string, data: any): Promise<any> {

    console.log("data", data);
    return axios({
      method: method,
      url: url,
      data: data
    }).then((response) => {
      const jwtToken = response.headers['Authorization'];


      if (jwtToken) {
        localStorage.setItem('auth_token', jwtToken.replace('Bearer ', ''));
      }
      console.log(response);
      return response;
    })
    .catch((error) => {
      console.error('Request failed:', error);
      throw error;
    });
  }
}
