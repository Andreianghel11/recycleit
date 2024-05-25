import { Injectable } from '@angular/core';
import {HttpClient, HttpErrorResponse} from "@angular/common/http";
import {BehaviorSubject, catchError, map, Observable, tap} from "rxjs";
import {Router} from "@angular/router";
import {WasteItemDto} from "../dtos/wasteItem.dto";
import {RecyclingFactDto} from "../dtos/recyclingFact.dto";
import {RecyclingHistoryService} from "./recycling-history.service";

@Injectable({
  providedIn: 'root'
})
export class PhotoService {
  private apiUrlPredict = 'http://localhost:8080/api/image/predict';
  private apiUrlRecyclingFact = 'http://localhost:8080/api/recyclingFacts/getRandomRecyclingFactByName';
  private resultSubject = new BehaviorSubject<{ imageUrl: string | ArrayBuffer | null, result: WasteItemDto | null }>({ imageUrl: null, result: null });
  result$ = this.resultSubject.asObservable();

  constructor(private http: HttpClient, private router: Router, private recyclingHistoryService: RecyclingHistoryService) {
  }

  uploadPhoto(photo: string | ArrayBuffer | null): Observable<WasteItemDto> {
    if (typeof photo === 'string') {
      const payload = { image: photo };
      return this.http.post<WasteItemDto>(this.apiUrlPredict, payload).pipe(
        tap(response => {
          this.resultSubject.next({ imageUrl: photo, result: response});
          if (response) {
            this.recyclingHistoryService.addRecyclingHistoryItem(response.wasteItemId, 1);
          }
        }),
        catchError((error: HttpErrorResponse) => {
          console.error('Error uploading photo:', error);
          this.resultSubject.next({ imageUrl: photo, result: null });
          throw error;
        })
      );
    } else {
      throw new Error('Invalid photo type');
    }
  }

  clearResult() {
    this.resultSubject.next({ imageUrl: null, result: null });
  }

  getRandomRecyclingFact(wasteItemName: string): Observable<RecyclingFactDto> {
    return this.http.get<RecyclingFactDto>(`${this.apiUrlRecyclingFact}/${wasteItemName}`).pipe(
      map(response => {
        return response;
      }),
      catchError((error: HttpErrorResponse) => {
        console.error('Error getting recycling fact:', error);
        throw error;
      })
    );
  }
}
