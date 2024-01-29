import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { CrudService } from '../services/crud.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-admin-crud-add',
  standalone: true,
  imports: [FormsModule, NgIf],
  templateUrl: './admin-crud-add.component.html',
  styleUrl: './admin-crud-add.component.scss'
})
export class AdminCrudAddComponent {
  user: any = {};
  error: string | null = null;

  passwordFirstShow: string = 'password';
  passwordSecShow: string = 'password';
  passwordError: string[] = [];
  emailError: string[] = [];

  constructor(private userService: CrudService, private router: Router) {}

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

  onSubmit(): void {
    this.passwordError = [];
    this.emailError = [];

    if (this.user.password !== this.user.passwordRepeat) {
      this.passwordError.push('Hasła nie są identyczne');
    }

    if (!this.user.email.includes('@')) {
      this.emailError.push('Email powinien zawierać znak @');
    }

    if (this.passwordError.length === 0 && this.emailError.length === 0) {
      this.userService.addUser(this.user).subscribe(
        () => {
          console.log('Użytkownik został dodany pomyślnie.');
          this.router.navigate(['/crud']);
        },
        (error) => {
          console.error('Błąd podczas dodawania użytkownika:', error);
        }
      );
    }
  }
}

