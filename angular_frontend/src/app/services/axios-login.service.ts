import { Injectable } from '@angular/core';
import { Router } from '@angular/router';
import axios, { Method } from 'axios';

@Injectable({
  providedIn: 'root'
})
export class AxiosLoginService {

  constructor(private router: Router) {
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
      return response;
    })
    .catch((error) => {
      console.error('Request failed:', error);
      throw error;
    });
  }

  logout(): void {
    localStorage.removeItem('auth_token');
    localStorage.removeItem('role');
    this.router.navigate(['']).then(() => {
      window.location.reload();
    });
  }

  isLoggedIn(): boolean {
    return !!localStorage.getItem('auth_token');
  }

}
