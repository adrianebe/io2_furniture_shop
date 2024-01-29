import { CartService } from './../services/cart.service';
import { EmployeeService } from './../services/employee.service';
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AssortmentService } from '../services/assortment.service';
import { NgIf } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-detail-product',
  standalone: true,
  imports: [NgIf, FormsModule],
  templateUrl: './detail-product.component.html',
  styleUrl: './detail-product.component.scss'
})
export class DetailProductComponent implements OnInit{
  assortmentItem: any;

  constructor(
    private route: ActivatedRoute,
    private assortmentService: AssortmentService,
    private employeeService: EmployeeService,
    private cartService: CartService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.loadAssortmentItem(id);
      }
    });
  }

  loadAssortmentItem(id: number): void {
    this.assortmentService.getAssortmentById(id).subscribe(
      (data) => {
        console.log(data, localStorage)
        this.assortmentItem = data;

      },
      (error) => {
        console.error('Error loading assortment item:', error);
      }
    );
  }

  isGuest(): boolean {
    const roles = localStorage.getItem('role');
    return roles === '';
  }

  isUser(): boolean {
    const roles = localStorage.getItem('role');
    return roles === 'USER';
  }


  isEmployee(): boolean {
    const roles = localStorage.getItem('role');
    return roles === 'EMPLOYEE';
  }

  addToCart(): void {
    this.cartService.addToCart(this.assortmentItem);
    if (this.assortmentItem.roomType === 'livingRoom') {
      this.router.navigate(["/living_room"]);
    } else {
      this.router.navigate(["/", this.assortmentItem.roomType]);
    }
  }

  deleteItem(): void {
    this.employeeService.deleteAssortment(this.assortmentItem.id).subscribe(
      () => {
        if (this.assortmentItem.roomType === 'livingRoom') {
          this.router.navigate(["/living_room"]);
        } else {
        this.router.navigate(["/", this.assortmentItem.roomType]);
        }
      },
      (error) => {
        console.error('Error deleting user:', error);
      }
    );
  }
}
