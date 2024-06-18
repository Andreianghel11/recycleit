import { Component } from '@angular/core';
import {ActivatedRoute, Router} from "@angular/router";
import {PhotoService} from "../../services/photo.service";
import {WasteItemDto} from "../../dtos/wasteItem.dto";
import {RecyclingFactDto} from "../../dtos/recyclingFact.dto";
import {UserDto} from "../../dtos/user.dto";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-result-page',
  templateUrl: './result-page.component.html',
  styleUrl: './result-page.component.css'
})
export class ResultPageComponent {
  imageUrl: string | ArrayBuffer | null = null;
  result: WasteItemDto | null = null;
  recylingFactDto: RecyclingFactDto | null = null;
  user: UserDto = {
    userId: 0,
    email: '',
    passwordHash: '',
    createdAt: new Date(),
    firstname: '',
    lastname: '',
    role: '',
    picture: '',
    itemsScanned: 0,
    title: '',
    plasticItemsScanned: 0,
    metalItemsScanned: 0,
    glassItemsScanned: 0,
    cardboardItemsScanned: 0,
    biologicalItemsScanned: 0,
    batteryItemsScanned: 0,
    paperItemsScanned: 0,
    shoesItemsScanned: 0,
    clothesItemsScanned: 0,
    trashItemsScanned: 0
  };
  errorMessage: string = '';

  constructor(private photoService: PhotoService, private userService : UserService, private router: Router) {}

  ngOnInit(): void {
    this.photoService.result$.subscribe(data => {
      this.imageUrl = data.imageUrl;
      this.result = data.result;

      if (this.result && this.result.name) {
        this.getRandomRecyclingFact(this.result.name);
      }

      this.userService.getCurrentUser().subscribe({
        next: (user) => this.user = user,
        error: (err) => this.errorMessage = 'Failed to load user data'
      });
      console.log(this.user);

    });
  }

  getRandomRecyclingFact(wasteItemName: string)  {
    this.photoService.getRandomRecyclingFact(wasteItemName).subscribe(data => {
      this.recylingFactDto = data;
    });
  }

  onProfileClick() {
    this.router.navigate(['/profile']);
  }
}
