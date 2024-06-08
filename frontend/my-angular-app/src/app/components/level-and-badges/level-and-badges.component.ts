import { Component } from '@angular/core';
import {UserAchievementDto} from "../../dtos/userAchievement.dto";
import {LevelAndBadgesService} from "../../services/level-and-badges.service";

@Component({
  selector: 'app-level-and-badges',
  templateUrl: './level-and-badges.component.html',
  styleUrl: './level-and-badges.component.css'
})
export class LevelAndBadgesComponent {
  userAchievements: UserAchievementDto[] = [];
  displayedAchievements: UserAchievementDto[] = [];
  page: number = 0;
  size: number = 8;
  totalPages = 0;


  constructor(private levelAndBadgesService : LevelAndBadgesService) {}

  ngOnInit(): void {
    this.loadUserAchievements();
  }

  loadUserAchievements(): void {
    this.levelAndBadgesService.getUserAchievements().subscribe( data => {
      this.userAchievements = data;
      this.totalPages = Math.ceil(this.userAchievements.length / this.size);
      this.updateDisplayedAchievements();
      console.log('User achievements:', this.userAchievements);
    }, error => {
      console.error('Error fetching user achievements:', error);
    });
  }

  updateDisplayedAchievements(): void {
    const start = this.page * this.size;
    const end = start + this.size;
    this.displayedAchievements = this.userAchievements.slice(start, end);
  }

  nextPage(): void {
    if (this.page < this.totalPages - 1) {
      this.page++;
      this.updateDisplayedAchievements();
    }
  }

  previousPage(): void {
    if (this.page > 0) {
      this.page--;
      this.updateDisplayedAchievements();
    }
  }

  // Utility function to transform "Waste Warrior" to "wasteWarrior"
  transformToCamelCase(str: string): string {
    return str
      .toLowerCase()
      .split(' ')
      .map((word, index) => index === 0 ? word : word.charAt(0).toUpperCase() + word.slice(1))
      .join('');
  }

  getImageUrl(imageName: string): string {
    const camelCaseName = this.transformToCamelCase(imageName);
    return `assets/achievements/${camelCaseName}.png`;
  }

  getCompletionPercentage(achievement : UserAchievementDto): number {
    return Math.round((achievement.progress / achievement.achievement.target) * 100);
  }

  protected readonly Math = Math;
}
