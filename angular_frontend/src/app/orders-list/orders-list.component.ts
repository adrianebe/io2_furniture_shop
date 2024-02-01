import { NgFor, NgIf } from '@angular/common';
import { Component } from '@angular/core';
import { EmployeeService } from '../services/employee.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-orders-list',
  standalone: true,
  imports: [NgFor, NgIf],
  templateUrl: './orders-list.component.html',
  styleUrl: './orders-list.component.scss'
})
export class OrdersListComponent {
  orders: any[] = [];

  constructor(private empService: EmployeeService, private router: Router) {}

  ngOnInit(): void {
    this.loadOrders();
  }

  toggleDetails(order: any): void {
    order.showDetails = !order.showDetails;
  }

  loadOrders(): void {
    this.empService.getAllOrders().subscribe(
      (data) => {
        this.orders = data;
        console.log(data);


      },
      (error) => {
        console.error('Error loading orders:', error);
      }
    );
  }

  goToEditOrder(orderId: number): void {
    this.router.navigate(['/order', orderId]);
  }
}

