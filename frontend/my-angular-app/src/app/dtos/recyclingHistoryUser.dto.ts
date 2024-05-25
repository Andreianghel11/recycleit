import {WasteItemDto} from "./wasteItem.dto";

export interface RecyclingHistoryUserDto {
  wasteItem: WasteItemDto;
  quantity: number;
  timestamp: Date;
}
