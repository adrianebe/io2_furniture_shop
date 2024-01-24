import { NgFor, NgIf } from '@angular/common';
import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login-form',
  standalone: true,
  imports: [FormsModule, NgIf, NgFor],
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.scss'
})
export class LoginFormComponent{

  @Output() onSubmitLoginEvent = new EventEmitter();
  errors: string[] = [];

  email: string = "";
  password: string = "";

  onSubmitLogin(): void {
    const formData = {"email": this.email, "password": this.password};
    console.log('Przekazane dane:', formData);
    this.onSubmitLoginEvent.emit(formData);
  }

  passwordFieldType: string = 'password';

  showPassword() {
    this.passwordFieldType = 'text';
  }

  hidePassword() {
    this.passwordFieldType = 'password';
  }

  handleError(error: any): void {
    this.errors = [];
    if (error === 'invalid_password') {
      this.errors.push('Nieprawidłowe hasło');
    } else if (error === 'invalid_email') {
      this.errors.push('Nieprawidłowy email');
    } else {
      this.errors.push('Niepoprawne dane');
    }

    console.error('Błąd w formularzu logowania:', error, this.errors);
  }
}
