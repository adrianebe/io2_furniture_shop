import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { UserService } from '../services/user.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-admin-crud-edit',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './admin-crud-edit.component.html',
  styleUrl: './admin-crud-edit.component.scss'
})
export class AdminCrudEditComponent implements OnInit {
  userId: number = 0;
  user: any = {
    name: '',
    lastName: '',
    email: '',
    password: '',
    confirmPassword: '',
    role: ''
  };
  passwordShow: boolean = false;
  confirmPasswordShow: boolean = false;
  passwordError: string[] = [];

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private userService: UserService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.userId = +params['id'];
      this.loadUserData();
    });
  }

  loadUserData(): void {
    this.userService.getUserById(this.userId).subscribe(
      (userData) => {
        this.user = userData;
      },
      (error) => {
        console.error('Error loading user data:', error);
      }
    );
  }

  showPassword(): void {
    this.passwordShow = !this.passwordShow;
  }

  showConfirmPassword(): void {
    this.confirmPasswordShow = !this.confirmPasswordShow;
  }

  onSubmit(): void {
    if (this.user.password !== this.user.confirmPassword) {
      this.passwordError.push('Passwords do not match');
      return;
    }

    this.userService.updateUser(this.userId, this.user).subscribe(
      (updatedUser) => {
        console.log('User updated successfully:', updatedUser);
        this.router.navigate(['/crud']);
      },
      (error) => {
        console.log(this.user)
        console.error('Error updating user:', error);
      }
    );
  }
}
