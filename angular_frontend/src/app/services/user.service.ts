import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  private apiUrl = 'http://localhost:8080/api/v1/user';

  constructor(private http: HttpClient) { }

  getAllAppUserOrders(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/orders`);
  }

  getOrderById(orderId: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/orders/${orderId}`);
  }

  createOrder(assortmentMapDto: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/orders`, assortmentMapDto);
  }

  cancelOrder(orderId: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/orders/${orderId}`);
  }

  getAllAppUserComplaints(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/complaints`);
  }

  getComplaintById(complaintId: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/complaints/${complaintId}`);
  }

  addNewComplaint(complaint: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/complaints`, complaint);
  }

  deleteAppUserComplaint(complaintId: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/complaints/${complaintId}`);
  }
}
