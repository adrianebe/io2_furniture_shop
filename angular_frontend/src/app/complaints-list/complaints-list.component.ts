import { NgFor } from '@angular/common';
import { Component } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-complaints-list',
  standalone: true,
  imports: [NgFor],
  templateUrl: './complaints-list.component.html',
  styleUrl: './complaints-list.component.scss'
})
export class ComplaintsListComponent {
  complaints: any[] = [];

  constructor(private empService: EmployeeService, private router: Router) {}

  ngOnInit(): void {
    this.loadComplaints();
  }

  loadComplaints(): void {
    this.empService.getAllComplaints().subscribe(
      (data) => {
        this.complaints = data;
        console.log(data);


      },
      (error) => {
        console.error('Error loading complaints:', error);
      }
    );
  }

  goToEditComplaint(orderId: number): void {
    this.router.navigate(['/complaints/edit/', orderId]);
  }
}
