import { NgFor, NgIf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AssortmentService } from '../services/assortment.service';
import { CartService } from '../services/cart.service';

interface CartItem {
  id: number;
  quantity: number;
}

interface DetailedCartItem {
  id: number;
  name: string;
  price: number;
  quantity: number;
  photo: string;
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
  detailedCartItems: DetailedCartItem[] = [];
  totalCartPrice: number = 0;

  constructor(private assortmentService: AssortmentService, private cartService: CartService) {}

  ngOnInit(): void {
    this.loadCartItems();
  }

  loadCartItems(): void {
    const cartIds = this.cartService.getCartItems();
    this.detailedCartItems = [];
    this.totalCartPrice = 0;
    console.log(cartIds);

    cartIds.forEach(cartItem => {
      this.assortmentService.getAssortmentById(cartItem.id).subscribe(
        (data) => {
          const detailedCartItem: DetailedCartItem = {
            id: data.id,
            name: data.name,
            price: data.price,
            quantity: cartItem.quantity,
            photo: data.photo
          };

          this.detailedCartItems.push(detailedCartItem);
          this.totalCartPrice += detailedCartItem.price * detailedCartItem.quantity;
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
}
