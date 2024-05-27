import {WasteItemDto} from "./wasteItem.dto";

export interface RecyclingHistoryUserDto {
  id: number;
  wasteItem: WasteItemDto;
  quantity: number;
  timestamp: Date;
  image: string;
}
