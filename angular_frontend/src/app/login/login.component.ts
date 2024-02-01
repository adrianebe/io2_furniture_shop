import { Component, ViewChild } from '@angular/core';
import { LoginFormComponent } from '../login-form/login-form.component';
import { AxiosLoginService } from '../services/axios-login.service';
import { Router } from '@angular/router';
import { JwtHelperService } from '@auth0/angular-jwt';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [LoginFormComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  @ViewChild(LoginFormComponent) loginForm!: LoginFormComponent;
  private jwtHelper: JwtHelperService = new JwtHelperService();

  constructor(private axiosLoginService: AxiosLoginService, private router: Router) {}

  onLogin(formData: any): void {
    this.axiosLoginService.request('POST', 'signin', formData)
      .then((response) => {
        console.log('Udane logowanie:', response);
        const jwtToken = response.data;
        const role: any = this.jwtHelper.decodeToken(jwtToken).role;

        if(jwtToken) {
          const tokenWithBearer = `Bearer ${jwtToken}`;
          localStorage.setItem('auth_token', tokenWithBearer);
          localStorage.setItem('role', role);
        }
        if(role ==='ADMIN') {
          this.router.navigate(['/crud']);
        } else {
          this.router.navigate(['/']);
        }

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
