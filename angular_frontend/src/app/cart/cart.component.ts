import { NgFor, NgIf } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { AssortmentService } from '../services/assortment.service';
import { CartService } from '../services/cart.service';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';
import { FormsModule } from '@angular/forms';

interface CartItem {
  id: number;
  quantity: number;
}

interface DetailedCartItem {
  id: number;
  name: string;
  price: number;
  count: number;
  photo: string;
}

interface AssortmentIdsAndCount {
  [key: number]: number;
}

@Component({
  selector: 'app-cart',
  standalone: true,
  imports: [NgIf, NgFor, FormsModule],
  templateUrl: './cart.component.html',
  styleUrl: './cart.component.scss'
})
export class CartComponent implements OnInit {
  cartItems: CartItem[] = [];
  detailedCartItems: DetailedCartItem[] = [];
  totalCartPrice: number = 0;

  deliveryInfo: {
    street: string;
    streetNumber: string;
    zipCode: string;
    city: string;
  } = {
    street: '',
    streetNumber: '',
    zipCode: '',
    city: ''
  };

  deliveryData: string = '';

  constructor(private assortmentService: AssortmentService, private cartService: CartService, private userService: UserService, private router: Router) {}

  ngOnInit(): void {
    this.loadCartItems();
  }


  loadCartItems(): void {
    const cartItems = this.cartService.getCartItems();
    this.detailedCartItems = [];
    this.totalCartPrice = 0;

    cartItems.forEach(cartItem => {
      this.assortmentService.getAssortmentById(cartItem.id).subscribe(
        (data) => {
          const detailedCartItem: DetailedCartItem = {
            id: data.id,
            name: data.name,
            price: data.price,
            count: cartItem.count,
            photo: data.photo
          };

          this.detailedCartItems.push(detailedCartItem);
          this.totalCartPrice += detailedCartItem.price * detailedCartItem.count;
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

  createOrder(): void {
    this.deliveryData = `${this.deliveryInfo.street} ${this.deliveryInfo.streetNumber}, ${this.deliveryInfo.zipCode} ${this.deliveryInfo.city}`;
    if (this.cartService.getCartItems().length > 0) {
      const assortmentIdsAndCount: AssortmentIdsAndCount = {};
      this.cartService.getCartItems().forEach(cartItem => {
        assortmentIdsAndCount[cartItem.id] = cartItem.count;
      });
      const orderData = {
        assortmentIdsAndCount: assortmentIdsAndCount,
        deliveryAddress: this.deliveryData
      };

      console.log(this.deliveryData);
      this.userService.createOrder(orderData).subscribe(
        (response) => {
          console.log('Order created successfully:', response);
          localStorage.removeItem('cart');
          this.router.navigate(['/']);
        },
        (error) => {
          console.error('Error creating order:', error);
        }
      );
    } else {
      console.error('Cart is empty or delivery information is invalid.');
    }
  }
}
