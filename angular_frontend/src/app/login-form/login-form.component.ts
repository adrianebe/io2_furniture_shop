import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-login-form',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './login-form.component.html',
  styleUrl: './login-form.component.scss'
})
export class LoginFormComponent{

  @Output() onSubmitLoginEvent = new EventEmitter();

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
}
