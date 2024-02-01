import { NgFor, NgIf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { AssortmentService } from '../services/assortment.service';


@Component({
  selector: 'app-orders',
  standalone: true,
  imports: [NgFor, NgIf],
  templateUrl: './orders.component.html',
  styleUrl: './orders.component.scss'
})
export class OrdersComponent implements OnInit {
  orders: any[] = [];

  constructor(private userService: UserService) {}

  ngOnInit(): void {
    this.loadOrders();
  }

  toggleDetails(order: any): void {
    order.showDetails = !order.showDetails;
  }

  loadOrders(): void {
    this.userService.getAllAppUserOrders().subscribe(
      (data) => {
        this.orders = data;
        console.log(data);


      },
      (error) => {
        console.error('Error loading orders:', error);
      }
    );
  }

  // countProducts(): void {
  //   const productCounts: { [key: number]: number } = {};
  //   this.orders.forEach(order => {
  //     order.assortments.forEach((product: { id: number }) => {
  //       const productId = product.id;
  //       if (productCounts[productId] !== undefined) {
  //         productCounts[productId]++;
  //       } else {
  //         productCounts[productId] = 1;
  //       }
  //     });
  //   });
  // }


  deleteOrder(orderId: number): void {
    this.userService.cancelOrder(orderId).subscribe(
      (response) => {
        console.log('Order canceled successfully:', response);
        this.loadOrders();
      },
      (error) => {
        console.error('Error canceling order:', error);
      }
    );
  }
}
