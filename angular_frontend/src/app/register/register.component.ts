import { Component } from '@angular/core';
import { RegisterFormComponent } from '../register-form/register-form.component';
import { AxiosService } from '../services/axios.service';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [RegisterFormComponent],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss',
})
export class RegisterComponent {
  constructor(private axiosService: AxiosService) {}

  onRegister(input: any): void {
    this.axiosService
      .request('POST', 'signup', {
        name: input.name,
        lastName: input.lastName,
        email: input.email,
        password: input.password,
      })
      .then((response) => {
        console.log('Otrzymano token:', response.data.token);
        this.axiosService.setAuthToken(response.data.token);
      })
      .catch((error) => {
        console.error('Request failed:', error);
      });
  }
}
