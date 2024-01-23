import { Component } from '@angular/core';
import { LoginFormComponent } from '../login-form/login-form.component';
import { AxiosLoginService } from '../services/axios-login.service';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [LoginFormComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent{

  constructor(private axiosLoginService: AxiosLoginService) {}
  onLogin(formData: any): void {
    this.axiosLoginService.request(
      "POST",
      "signin", formData)
  //     .then(response => {
  //         this.axiosService.setAuthToken(response.data.token);
  //     })
  }
}
