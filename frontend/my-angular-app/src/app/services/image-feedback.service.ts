import { Injectable } from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {RecyclingHistoryCreateDto} from "../dtos/recyclingHistoryCreate.dto";
import {ImageFeedbackDto} from "../dtos/ImageFeedback.dto";

@Injectable({
  providedIn: 'root'
})
export class ImageFeedbackService {
  apiUrl: string = 'http://localhost:8080/api/imageFeedback/addImageFeedback';
  constructor(private http: HttpClient) { }

  addImageFeedback(wasteItemName: string, image: string | ArrayBuffer | null) {
    const headers = new HttpHeaders({ 'Content-Type': 'application/json' });
    const imageFeedbackDto : ImageFeedbackDto = {wasteItemName, image};

    return this.http.post(this.apiUrl, imageFeedbackDto, {headers}).subscribe(
      (response) => {
        console.log('Successfully added image feedback', response);
      },
      error => {
        console.error('Error adding image feedback:', error);
      }
    );
  }

}
