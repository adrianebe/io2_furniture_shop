import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AssortmentService {

  apiUrl = 'http://localhost:8080/api/v1'

  constructor(private http: HttpClient) { }

  getAssortment(): Observable<any[]> {
    return this.http.get<any[]>(`${this.apiUrl}/assortment`);
  }

  getPostById(id: number): Observable<any> {
    return this.http.get<any>(`${this.apiUrl}/assortment/${id}`);
  }

  addPost(post: any): Observable<any> {
    return this.http.post<any>(`${this.apiUrl}/assortment`, post);
  }

  updatePost(id: number, post: any): Observable<any> {
    return this.http.put<any>(`${this.apiUrl}/assortment/${id}`, post);
  }

  deletePost(id: number): Observable<any> {
    return this.http.delete<any>(`${this.apiUrl}/assortment/${id}`);
  }

  
}
