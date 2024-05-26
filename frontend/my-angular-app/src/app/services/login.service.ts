import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {catchError, map, Observable, throwError} from "rxjs";
import {Router} from "@angular/router";
import {RegisterDto} from "../dtos/register.dto";
import {LoginDto} from "../dtos/login.dto";

@Injectable({
  providedIn: 'root'
})
export class LoginService {
  private apiUrlLogin = 'http://localhost:8080/api/auth/authenticate';
  private apiUrlRegister = 'http://localhost:8080/api/auth/register';

  constructor(private http: HttpClient, private router: Router) { }

  login(loginDto : LoginDto): Observable<any> {
    return this.http.post<any>(this.apiUrlLogin, loginDto).pipe(
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

  register(registerDto : RegisterDto): Observable<any> {
    return this.http.post<any>(this.apiUrlRegister, registerDto).pipe(
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
      if (error.status === 409) {
        errorMessage = 'The user already exists';
      }
    }
    return throwError(errorMessage);
  }

  logout() {
    if (typeof window !== 'undefined')
      localStorage.removeItem('authToken');
    this.router.navigate(['/login']);
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
