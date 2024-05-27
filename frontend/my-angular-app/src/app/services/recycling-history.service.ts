import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {RecyclingHistoryUserDto} from "../dtos/recyclingHistoryUser.dto";
import {RecyclingHistoryCreateDto} from "../dtos/recyclingHistoryCreate.dto";

@Injectable({
  providedIn: 'root'
})
export class RecyclingHistoryService {
  private apiUrlAddRecyclingHistory = 'http://localhost:8080/api/recyclingHistory/addRecyclingHistory';
  private apiUrlGetRecyclingHistoryUser = 'http://localhost:8080/api/recyclingHistory/getRecyclingHistoryUser';
  private apiUrlDeleteRecyclingHistory = 'http://localhost:8080/api/recyclingHistory/deleteRecyclingHistory';
  constructor(private http: HttpClient) { }

  addRecyclingHistoryItem(wasteItemId: number, quantity: number, image: string | ArrayBuffer | null) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const recyclingHistoryCreateDto : RecyclingHistoryCreateDto = {wasteItemId, quantity, image}
    console.log("Addind recycling history item: ", recyclingHistoryCreateDto);

    return this.http.post(this.apiUrlAddRecyclingHistory, recyclingHistoryCreateDto, {headers}).subscribe(
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

  deleteRecyclingHistory(id: number) {
    console.log('Deleting recycling history item with id:', id);
    return this.http.delete(this.apiUrlDeleteRecyclingHistory + '/' + id).subscribe(
      (response) => {
        console.log('Successfully deleted recycling history item', response);
      },
      error => {
        console.error('Error deleting recycling history item:', error);
      }
    );
  }
}
