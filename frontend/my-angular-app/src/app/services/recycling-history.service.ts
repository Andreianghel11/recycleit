import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {RecyclingHistoryUserDto} from "../dtos/recyclingHistoryUser.dto";

@Injectable({
  providedIn: 'root'
})
export class RecyclingHistoryService {
  private apiUrlAddRecyclingHistory = 'http://localhost:8080/api/recyclingHistory/addRecyclingHistory';
  private apiUrlGetRecyclingHistoryUser = 'http://localhost:8080/api/recyclingHistory/getRecyclingHistoryUser';
  constructor(private http: HttpClient) { }

  addRecyclingHistoryItem(wasteItemId: number, quantity: number) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const payload = { wasteItemId, quantity };

    return this.http.post(this.apiUrlAddRecyclingHistory, payload, {headers}).subscribe(
      (response) => {
        console.log('Successfully added recycling history item', response);
      },
      error => {
        console.error('Error adding recycling history item:', error);
      }
    );
  }

  getRecyclingHistoryUser(): Observable<RecyclingHistoryUserDto[]> {
    return this.http.get<RecyclingHistoryUserDto[]>(this.apiUrlGetRecyclingHistoryUser);
  }
}
