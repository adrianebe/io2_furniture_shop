import { Injectable } from '@angular/core';
import {
  HttpEvent,
  HttpInterceptor,
  HttpHandler,
  HttpRequest,
} from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable()
export class TokenInterceptor implements HttpInterceptor {
  intercept(
    request: HttpRequest<any>,
    next: HttpHandler
  ): Observable<HttpEvent<any>> {
    const authToken = localStorage.getItem('auth_token');

    if (authToken) {
      const cloned = request.clone({
        setHeaders: {
          Authorization: authToken,
        },
      });

      return next.handle(cloned);
    }

    return next.handle(request);
  }
}
