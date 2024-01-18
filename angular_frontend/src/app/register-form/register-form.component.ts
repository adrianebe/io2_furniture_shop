import { Component, EventEmitter, Output } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { JsonPipe, NgIf } from '@angular/common';


@Component({
  selector: 'app-register-form',
  standalone: true,
  imports: [FormsModule, NgIf, JsonPipe],
  templateUrl: './register-form.component.html',
  styleUrl: './register-form.component.scss'
})
export class RegisterFormComponent {

  @Output() onSubmitRegisterEvent = new EventEmitter();

  email: string = "";
  name: string = "";
  lastName: string = "";
  passwordFirst: string = '';
  passwordSec: string = '';
  passwordChecked: string = '';
  passwordFirstShow: string = 'password';

  showFirstPassword() {
    this.passwordFirstShow = 'text';
  }

  hideFirstPassword() {
    this.passwordFirstShow = 'password';
  }

  passwordSecShow: string = 'password';


  showSecPassword() {
    this.passwordSecShow = 'text';
  }

  hideSecPassword() {
    this.passwordSecShow = 'password';
  }

  onSubmitRegister(): void {
    console.log( "email", this.email, "password", this.passwordFirst, "password2", this.passwordSec, "name", this.name, "lastName", this.lastName );
    if (this.passwordFirst === this.passwordSec){

      const formData = {"name": this.name, "lastName": this.lastName, "email": this.email, "password": this.passwordFirst};

      console.log('Przekazane dane po:', formData);
      this.onSubmitRegisterEvent.emit({ formData });
    }
  }

}
