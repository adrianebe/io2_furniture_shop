import { Component } from '@angular/core';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.scss'
})
export class LoginComponent {
  password: string = '';
  passwordFieldType: string = 'password';

  updatePassword(event: any) {
    this.password = event.target.value;
  }

  showPassword() {
    this.passwordFieldType = 'text';
  }

  hidePassword() {
    this.passwordFieldType = 'password';
  }
}
