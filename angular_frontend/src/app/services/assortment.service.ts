import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AssortmentService {

  apiUrl = 'http://localhost:8081/api/v1'

  constructor(private http: HttpClient) { }

  getAssortment(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/guest/assortment`);
  }

  getAssortmentById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/guest/assortment/id/${id}`);
  }

  getAssortmentByRoomType(roomType: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/guest/assortment/${roomType}`);
  }

  addAssortment(Assortment: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/employee/assortment`, Assortment);
  }

  updateAssortment(id: number, Assortment: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/employee/assortment/${id}`, Assortment);
  }

  deleteAssortment(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/employee/assortment/${id}`);
  }


}
