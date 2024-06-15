import {Component, ElementRef, ViewChild} from '@angular/core';
import {UserService} from "../../services/user.service";
import {UserDto} from "../../dtos/user.dto";

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrl: './profile.component.css'
})
export class ProfileComponent {
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

  wasteTypes: string[] = ['Plastic', 'Metal', 'Glass', 'Cardboard', 'Biological', 'Paper', 'Shoes', 'Clothes', 'Trash'];
  @ViewChild('fileInput', { static: false }) fileInput!: ElementRef;
  constructor(private userService : UserService) { }

  ngOnInit(): void {
    this.userService.getCurrentUser().subscribe({
      next: (user) => this.user = user,
      error: (err) => this.errorMessage = 'Failed to load user data'
    });
    console.log(this.user);
  }

  getNumberOfItemsScanned(waste: string): number {
    switch(waste) {
      case 'Plastic':
        return this.user.plasticItemsScanned;
      case 'Metal':
        return this.user.metalItemsScanned;
      case 'Glass':
        return this.user.glassItemsScanned;
      case 'Cardboard':
        return this.user.cardboardItemsScanned;
      case 'Biological':
        return this.user.biologicalItemsScanned;
      case 'Paper':
        return this.user.paperItemsScanned;
      case 'Shoes':
        return this.user.shoesItemsScanned;
      case 'Clothes':
        return this.user.clothesItemsScanned;
      case 'Trash':
        return this.user.trashItemsScanned;
      default:
        return 0;
    }
  }

  triggerFileInput(): void {
    this.fileInput.nativeElement.click();
  }

  onFileSelected(event: Event): void {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files[0]) {
      const file = input.files[0];
      const reader = new FileReader();

      reader.onload = (e: any) => {
        this.user.picture = e.target.result;
        this.updateUserPicture(e.target.result);
      };
      reader.readAsDataURL(file);
    }
  }

  updateUserPicture(picture: string): void {
    this.userService.updateUserPicture(this.user.userId, picture).subscribe({
      next: (user) => {
        this.user = user;
        this.errorMessage = '';
      },
      error: (err) => this.errorMessage = 'Failed to update user data'
    });
  }

}
