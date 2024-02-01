import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { EmployeeService } from '../services/employee.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-edit-order',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './edit-order.component.html',
  styleUrl: './edit-order.component.scss'
})
export class EditOrderComponent implements OnInit {
  editedOrder: any = {};
  orderId!: number;

  constructor(private employeeService: EmployeeService, private route: ActivatedRoute, private router: Router) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.orderId = +params['id'];
      this.loadOrderDetails();
    });
  }

  loadOrderDetails(): void {
    this.employeeService.getOrderById(this.orderId).subscribe(
      (data) => {
        this.editedOrder = data;
        console.log(data);

      },
      (error) => {
        console.error('Error loading order details:', error);
      }
    );
  }

  updateOrder(): void {
    this.employeeService.updateOrder(this.orderId, this.editedOrder).subscribe(
      (response) => {
        console.log('Order updated successfully:', response);
        this.router.navigate(['/orders/list']);
      },
      (error) => {
        console.error('Error updating order:', error);
      }
    );
  }
}
