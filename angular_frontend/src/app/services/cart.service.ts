import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private cartItems: any[] = [];

  getCartItems(): any[] {
    return this.getCartItemsFromLocalStorage();
  }

  addToCart(item: any): void {
    this.cartItems = this.getCartItemsFromLocalStorage();
    const existingItemIndex = this.cartItems.findIndex(cartItem => cartItem.id === item.id);

    if (existingItemIndex !== -1) {
      this.cartItems[existingItemIndex].quantity += 1;
    } else {
      this.cartItems.push({ id: item.id, quantity: 1 });
    }
    this.updateLocalStorage();
  }

  private getCartItemsFromLocalStorage(): any[] {
    const storedItems = localStorage.getItem('cart');
    return storedItems ? JSON.parse(storedItems) : [];
  }


  removeFromCart(itemId: number): void {
    const indexToRemove = this.cartItems.findIndex(item => item.id === itemId);

    if (indexToRemove !== -1) {
      if (this.cartItems[indexToRemove].quantity === 1) {
        this.cartItems.splice(indexToRemove, 1);
      } else {
        this.cartItems[indexToRemove].quantity -= 1;
      }

      this.updateLocalStorage();
    }
  }


  private updateLocalStorage(): void {
    localStorage.setItem('cart', JSON.stringify(this.cartItems));
  }


}
