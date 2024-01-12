import { Component, EventEmitter, NgModule, Output } from '@angular/core';
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
    // this.onSubmitLoginEvent.emit({"email": this.email, "password": this.password});
    const formData = {"email": this.email, "password": this.password};
    console.log('Przekazane dane:', formData);
    this.onSubmitLoginEvent.emit(formData);
  }


  passwordFieldType: string = 'password';

  updatePassword(event: any) {
    this.password = event.target.value;
  }

  updateEmail(event: any) {
    this.email = event.target.value;
  }

  showPassword() {
    this.passwordFieldType = 'text';
  }

  hidePassword() {
    this.passwordFieldType = 'password';
  }
}
