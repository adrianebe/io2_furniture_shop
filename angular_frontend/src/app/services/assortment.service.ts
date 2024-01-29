import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AssortmentService {

  apiUrl = 'http://localhost:8080/api/v1/guest'

  constructor(private http: HttpClient) { }

  getAssortment(): Observable<any[]> {
    console.log(localStorage);

    return this.http.get<any[]>(`${this.apiUrl}/assortment`);
  }

  getAssortmentById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/assortment/id/${id}`);
  }

  getAssortmentByRoomType(roomType: string): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/assortment/${roomType}`);
  }


}
