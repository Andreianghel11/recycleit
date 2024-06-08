import {AchievementDto} from "./achievement.dto";

export interface UserAchievementDto {
  userAchievementId: number;
  achievement: AchievementDto;
  progress: number;
  isCompleted: boolean;
  timestamp: Date;
}
