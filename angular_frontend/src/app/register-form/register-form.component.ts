import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { JsonPipe, NgIf } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register-form',
  standalone: true,
  imports: [FormsModule, NgIf, JsonPipe],
  templateUrl: './register-form.component.html',
  styleUrl: './register-form.component.scss'
})
export class RegisterFormComponent {

  @Output() onSubmitRegisterEvent = new EventEmitter();
  passwordError: string[] = [];
  emailError: string[] = [];
  email: string = "";
  name: string = "";
  lastName: string = "";
  passwordFirst: string = '';
  passwordSec: string = '';
  passwordChecked: string = '';
  passwordFirstShow: string = 'password';
  passwordSecShow: string = 'password';

  constructor(private router: Router) {}

  showFirstPassword() {
    this.passwordFirstShow = 'text';
  }

  hideFirstPassword() {
    this.passwordFirstShow = 'password';
  }

  showSecPassword() {
    this.passwordSecShow = 'text';
  }

  hideSecPassword() {
    this.passwordSecShow = 'password';
  }
  onSubmitRegister(): void {
    if (this.passwordFirst === this.passwordSec && this.email.includes('@')) {
      const formData = {"name": this.name, "lastName": this.lastName, "email": this.email, "password": this.passwordFirst};
      console.log('Przekazane dane po:', formData);
      this.onSubmitRegisterEvent.emit(formData);
      this.router.navigate(['/login']);
    } else {
      if (this.passwordFirst !== this.passwordSec) {
        this.passwordError.push('Hasła nie są identyczne');
      }
      if (!this.email.includes('@')) {
        this.emailError.push('Email powinien zawierać znak @');
      }
    }
  }
}
