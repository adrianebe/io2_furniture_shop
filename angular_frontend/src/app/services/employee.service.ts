import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmployeeService {

  private apiUrl = 'http://localhost:8080/api/v1/employee';

  constructor(private http: HttpClient) { }

  addAssortment(assortment: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/assortment`, assortment);
  }

  updateAssortment(assortmentId: number, assortment: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/assortment/${assortmentId}`, assortment);
  }

  deleteAssortment(assortmentId: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/assortment/${assortmentId}`);
  }

  getAllFinancialReports(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/report`);
  }

  getOneFinancialReport(reportId: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/report/${reportId}`);
  }

  generateFinancialReport(dates: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/report`, dates);
  }

  deleteFinancialReport(reportId: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/report/${reportId}`);
  }

  getAllComplaints(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/complaint`);
  }

  getComplaintById(complaintId: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/complaint/${complaintId}`);
  }

  updateComplaint(complaintId: number, complaintDto: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/complaint/${complaintId}`, complaintDto);
  }

  deleteComplaint(complaintId: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/complaint/${complaintId}`);
  }

  getAllOrders(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/orders`);
  }

  updateOrder(orderId: number, updatedOrder: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/orders/${orderId}`, updatedOrder);
  }
}
