import { Router } from '@angular/router';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-admin-crud',
  standalone: true,
  imports: [NgFor],
  templateUrl: './admin-crud.component.html',
  styleUrl: './admin-crud.component.scss'
})
export class AdminCrudComponent implements OnInit {
  users: any[] = [];

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {
    this.loadUsers();
  }

  loadUsers(): void {
    this.userService.getAllUsers().subscribe(
      (data) => {
        this.users = data;
        console.log(data)
      },
      (error) => {
        console.error('Error loading users:', error);
      }
    );
  }

  addUser(): void {
    this.router.navigate(['/crud_add']);
  }

  editUser(userId: number): void {
    this.router.navigate(['/crud_edit', userId]);
  }

  deleteUser(userId: number): void {
    this.userService.deleteUser(userId).subscribe(
      () => {
        this.loadUsers();
      },
      (error) => {
        console.error('Error deleting user:', error);
      }
    );
  }
}
