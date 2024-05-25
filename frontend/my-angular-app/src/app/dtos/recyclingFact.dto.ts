import {WasteItemDto} from "./wasteItem.dto";

export interface RecyclingFactDto {
  recyclingFactId: number;
  wasteItemDto: WasteItemDto;
  fact: string;
}
