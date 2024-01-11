import { Component } from '@angular/core';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [],
  templateUrl: './register.component.html',
  styleUrl: './register.component.scss'
})
export class RegisterComponent {
  password: string = '';
  passwordFirst: string = 'password';

  updateFirstPassword(event: any) {
    this.password = event.target.value;
  }

  showFirstPassword() {
    this.passwordFirst = 'text';
  }

  hideFirstPassword() {
    this.passwordFirst = 'password';
  }

  passwordSec: string = 'password';

  updateSecPassword(event: any) {
    this.password = event.target.value;
  }

  showSecPassword() {
    this.passwordSec = 'text';
  }

  hideSecPassword() {
    this.passwordSec = 'password';
  }
}
