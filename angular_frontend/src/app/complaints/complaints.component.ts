import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-complaints',
  standalone: true,
  imports: [NgFor],
  templateUrl: './complaints.component.html',
  styleUrl: './complaints.component.scss'
})
export class ComplaintsComponent {
  complaints: any[] = [];

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.loadComplaints();
  }

  loadComplaints(): void {
    this.userService.getAllAppUserComplaints().subscribe(
      (data) => {
        this.complaints = data;
        console.log(data);


      },
      (error) => {
        console.error('Error loading complaints:', error);
      }
    );
  }

  deleteComplaint(orderId: number): void {
    this.userService.cancelOrder(orderId).subscribe(
      (response) => {
        console.log('Complaint canceled successfully:', response);
        this.loadComplaints();
      },
      (error) => {
        console.error('Error canceling complaint:', error);
      }
    );
  }
}
