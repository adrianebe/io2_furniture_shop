import { Component, ViewChild } from '@angular/core';
import { LoginFormComponent } from '../login-form/login-form.component';
import { AxiosLoginService } from '../services/axios-login.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [LoginFormComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  @ViewChild(LoginFormComponent) loginForm!: LoginFormComponent;

  constructor(private axiosLoginService: AxiosLoginService, private router: Router) {}

  onLogin(formData: any): void {
    this.axiosLoginService.request('POST', 'signin', formData)
      .then((response) => {
        console.log('Udane logowanie:', response);
        const jwtToken = response.data;
        if(jwtToken) {
          const tokenWithBearer = `Bearer ${jwtToken}`;
          localStorage.setItem('auth_token', tokenWithBearer);
        }
        this.router.navigate(['/']);
        console.log(localStorage);
      })
      .catch((error) => {
        if (error.response && error.response.status === 400) {
          this.loginForm.handleError('invalid_password');
        } else if (error.response && error.response.status === 401) {
          this.loginForm.handleError('invalid_email');
        } else {
          console.error('Request failed:', error);
        }
      });
  }
}
