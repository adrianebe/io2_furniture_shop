import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private cartItems: any[] = [];

  getCartItems(): any[] {
    console.log('data', this.getCartItemsFromLocalStorage());
    return this.getCartItemsFromLocalStorage();
  }

  addToCart(item: any): void {
    this.cartItems = this.getCartItemsFromLocalStorage();
    const existingItemIndex = this.cartItems.findIndex(cartItem => cartItem.id === item.id);

    if (existingItemIndex !== -1) {
      this.cartItems[existingItemIndex].count += 1;
    } else {
      this.cartItems.push({ id: item.id, count: 1 });
    }
    this.updateLocalStorage(this.cartItems);
  }

  private getCartItemsFromLocalStorage(): any[] {
    const storedItems = localStorage.getItem('cart');
    return storedItems ? JSON.parse(storedItems) : [];
  }


  removeFromCart(itemId: number): void {
    const items = this.getCartItems();
    let itemIndex = -1;


    for (let i = 0; i < items.length; i++) {
      if (items[i].id === itemId) {
        itemIndex = i;
        break;
      }
    }

    if (itemIndex !== -1) {
      if (items[itemIndex].count === 1) {
        items.splice(itemIndex, 1);
      } else {
        items[itemIndex].count -= 1;
      }

      this.updateLocalStorage(items);
    } else {
      console.log('Nie znaleziono przedmiotu o ID:', itemId);
    }
  }

  updateLocalStorage(items: any[]): void {
    localStorage.setItem('cart', JSON.stringify(items));
  }


}
