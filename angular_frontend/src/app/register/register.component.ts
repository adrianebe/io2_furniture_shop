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

  onRegister(formData: any): void {
    this.axiosService
      .request('POST', 'signup', formData)

  }
}
