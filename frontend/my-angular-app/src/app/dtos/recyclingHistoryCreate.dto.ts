export interface RecyclingHistoryCreateDto {
  wasteItemId: number;
  quantity: number;
  image: string | ArrayBuffer | null;
}
