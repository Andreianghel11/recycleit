import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders, HttpParams} from "@angular/common/http";
import {Observable} from "rxjs";
import {RecyclingHistoryUserDto} from "../dtos/recyclingHistoryUser.dto";
import {RecyclingHistoryCreateDto} from "../dtos/recyclingHistoryCreate.dto";
import {Page} from "../dtos/page.dto";

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
    const timestamp = new Date();
    const recyclingHistoryCreateDto : RecyclingHistoryCreateDto = {wasteItemId, quantity, image, timestamp};
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

  getRecyclingHistoryUser(page: number, size: number): Observable<Page<RecyclingHistoryUserDto>> {
    let params = new HttpParams();
    params = params.append('page', page.toString());
    params = params.append('size', size.toString());
    return this.http.get<Page<RecyclingHistoryUserDto>>(this.apiUrlGetRecyclingHistoryUser, {params});
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
