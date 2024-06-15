import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserDto} from "../dtos/user.dto";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiGetUserUrl = 'http://localhost:8080/api/user/getCurrentUser'
  private apiUpdateUserPictureUrl = 'http://localhost:8080/api/user/updatePicture'

  constructor(private http: HttpClient) {}

  getCurrentUser() {
    return this.http.get<UserDto>(this.apiGetUserUrl);
  }

  updateUserPicture(userId: number, picture: string): Observable<UserDto> {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const payload = { userId, picture };
    return this.http.put<UserDto>(this.apiUpdateUserPictureUrl, payload, { headers });
  }
}
