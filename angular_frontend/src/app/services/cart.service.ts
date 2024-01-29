import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private cartItems: any[] = [];

  getCartItems(): any[] {
    return this.cartItems;
  }

  addToCart(item: any): void {
    this.cartItems = this.getCartItemsFromLocalStorage();
    this.cartItems.push(item.id);
    this.updateLocalStorage();
  }

  private getCartItemsFromLocalStorage(): any[] {
    const storedItems = localStorage.getItem('cart');
    return storedItems ? JSON.parse(storedItems) : [];
  }


  removeFromCart(itemId: number): void {
    this.cartItems = this.cartItems.filter(item => item.id !== itemId);
    this.updateLocalStorage();
  }

  private updateLocalStorage(): void {
    localStorage.setItem('cart', JSON.stringify(this.cartItems));
  }
}
