import { Component } from '@angular/core';
import { LoginFormComponent } from '../login-form/login-form.component';
import { AxiosService } from '../services/axios.service';
@Component({
  selector: 'app-login',
  standalone: true,
  imports: [LoginFormComponent],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent{

  constructor(private axiosService: AxiosService) {}
  onLogin(input: any): void {
    this.axiosService.request(
      "POST",
      "signin",
      {
        email: input.email,
        password: input.password
      }
    )
  }
}
