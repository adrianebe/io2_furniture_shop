import { Component, ViewChild } from '@angular/core';
import { LoginFormComponent } from '../login-form/login-form.component';
import { AxiosLoginService } from '../services/axios-login.service';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [LoginFormComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {

  @ViewChild(LoginFormComponent) loginForm!: LoginFormComponent;

  constructor(private axiosLoginService: AxiosLoginService) {}

  onLogin(formData: any): void {
    this.axiosLoginService.request('POST', 'signin', formData)
      .then((response) => {
        console.log('Udane logowanie:', response);
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
