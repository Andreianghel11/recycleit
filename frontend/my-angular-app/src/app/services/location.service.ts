import { Injectable } from '@angular/core';
import {Observable} from "rxjs";
import {HttpClient, HttpParams} from "@angular/common/http";
import {LocationDto} from "../dtos/location.dto";

@Injectable({
  providedIn: 'root'
})
export class LocationService {
  private apiUrl = 'http://localhost:8080/api/recyclingCenters/getRecyclingCenters';

  constructor(private http: HttpClient) { }

  getCurrentLocation(): Promise<GeolocationPosition> {
    return new Promise((resolve, reject) => {
      if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(resolve, reject);
      } else {
        reject('Geolocation is not supported by this browser.');
      }
    });
  }

  getNearbyRecyclingCenters(latitude: number, longitude: number, radius: number): Observable<any> {
    let params = new HttpParams();
    params = params.append('latitude', latitude.toString());
    params = params.append('longitude', longitude.toString());
    params = params.append('radius', radius.toString());
    return this.http.get<LocationDto[]>(this.apiUrl, {params});
  }
}
