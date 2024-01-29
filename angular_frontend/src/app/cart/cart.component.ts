import { NgFor, NgIf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AssortmentService } from '../services/assortment.service';
import { CartService } from '../services/cart.service';

interface CartItem {
  id: number;
  quantity: number;
}

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [NgIf, NgFor],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.scss'
})
export class CartComponent implements OnInit {
  cartItems: CartItem[] = [];
  detailedCartItems: any[] = [];

  constructor(private assortmentService: AssortmentService, private cartService: CartService) {}

  ngOnInit(): void {
    this.loadCartItems();
  }

  loadCartItems(): void {
    const cartIds = this.cartService.getCartItems();
    const uniqueCartIds = Array.from(new Set(cartIds));
    this.cartItems = uniqueCartIds.map(id => ({ id, quantity: cartIds.filter(c => c === id).length }));
    console.log(localStorage);
    this.detailedCartItems = [];

    this.cartItems.forEach(cartItem => {
      this.assortmentService.getAssortmentById(cartItem.id).subscribe(
        (data) => {


          const detailedCartItem = { ...data, quantity: cartItem.quantity };
          this.detailedCartItems.push(detailedCartItem);
        },
        (error) => {
          console.error('Error loading cart item:', error);
        }
      );
    });
  }

  removeFromCart(itemId: number): void {
    this.cartService.removeFromCart(itemId);
    this.loadCartItems();
  }

  calculateTotalPrice(): number {
    return this.detailedCartItems.reduce((total, item) => total + item.price * item.quantity, 0);
  }
}
