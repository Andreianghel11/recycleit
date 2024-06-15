export interface UserDto {
  userId: number;
  email: string;
  passwordHash: string;
  createdAt: Date;
  firstname: string;
  lastname: string;
  role: string;
  picture: string;
  itemsScanned: number;
  title: string;
  plasticItemsScanned: number;
  metalItemsScanned: number;
  glassItemsScanned: number;
  cardboardItemsScanned: number;
  biologicalItemsScanned: number;
  batteryItemsScanned: number;
  paperItemsScanned: number;
  shoesItemsScanned: number;
  clothesItemsScanned: number;
  trashItemsScanned: number;
}
