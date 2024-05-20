import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {catchError, map, Observable, throwError} from "rxjs";

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private apiUrl = 'http://localhost:8080/api/v1/auth/authenticate';

  constructor(private http: HttpClient) { }

  login(email: string, password: string): Observable<any> {
    const loginData = { email, password };
    return this.http.post<any>(this.apiUrl, loginData).pipe(
      map(response => {
        // Store the token in local storage
        if (typeof window !== 'undefined') {
          localStorage.setItem('authToken', response.token);
        }
        return response;
      }),
      catchError(this.handleError)
    );
  }

  private handleError(error: HttpErrorResponse) {
    let errorMessage = 'An unknown error occurred!';
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred.
      errorMessage = `An error occurred: ${error.error.message}`;
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      if (error.status === 401) {
        errorMessage = 'Invalid email or password';
      } else {
        errorMessage = `Backend returned code ${error.status}, body was: ${error.error.message || error.message}`;
      }
    }
    return throwError(errorMessage);
  }

  logout() {
    if (typeof window !== 'undefined')
      localStorage.removeItem('authToken');
  }

  getToken(): string | null {
    if (typeof window !== 'undefined')
      return localStorage.getItem('authToken');
    return null;
  }

  isLoggedIn(): boolean {
    return this.getToken() !== null;
  }
}
