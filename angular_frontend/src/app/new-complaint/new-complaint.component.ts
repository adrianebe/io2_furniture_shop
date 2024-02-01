import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { NgFor } from '@angular/common';

interface Complaint {
  orderId: number;
  description: string;
  userId: number;
}

@Component({
  selector: 'app-new-complaint',
  standalone: true,
  imports: [FormsModule, NgFor],
  templateUrl: './new-complaint.component.html',
  styleUrl: './new-complaint.component.scss'
})

export class NewComplaintComponent implements OnInit {
  userOrders: any[] = [];
  selectedOrderId: number = 0;
  newComplaint: Complaint = { orderId: 0, description: '', userId: 0 };

  constructor(private userService: UserService, private router: Router) {}

  ngOnInit(): void {
    this.loadUserOrders();
  }

  loadUserOrders(): void {
    this.userService.getAllAppUserOrders().subscribe(
      (data) => {
        this.userOrders = data;
        console.log(data);

      },
      (error) => {
        console.error('Error loading user orders:', error);
      }
    );
  }

  submitComplaint(): void {
    if (this.selectedOrderId === 0) {
      console.error('Wybierz zamówienie przed złożeniem reklamacji.');
      return;
    }

    const complaintData = {
      orderId: this.selectedOrderId,
      description: this.newComplaint.description
    };

    this.userService.addNewComplaint(complaintData).subscribe(
      (response) => {
        console.log('Reklamacja złożona pomyślnie:', response);
        this.router.navigate(['/complaints']);
      },
      (error) => {
        console.error('Błąd podczas składania reklamacji:', error);
      }
    );
  }
}
