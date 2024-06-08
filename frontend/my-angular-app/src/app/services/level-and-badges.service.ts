import { Injectable } from '@angular/core';
import {UserAchievementDto} from "../dtos/userAchievement.dto";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class LevelAndBadgesService {
  private apiUrlGetUserAchievements = 'http://localhost:8080/api/userAchievements/getAllUserAchievements';
  constructor(private http: HttpClient) { }

  getUserAchievements() {
    return this.http.get<UserAchievementDto[]>(this.apiUrlGetUserAchievements);
  }
}
