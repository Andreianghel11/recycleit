import { Component } from '@angular/core';
import {PhotoService} from "../../services/photo.service";
import {LoginService} from "../../services/login.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrl: './menu.component.css'
})
export class MenuComponent {
  photo: string | ArrayBuffer | null = null;

  constructor(private photoService: PhotoService, private loginService: LoginService, private router: Router) {

  }

  onCameraClick(fileInput: HTMLInputElement) {
    this.photoService.clearResult();
    fileInput.click();
  }

  onLastScansClick() {
    this.router.navigate(['/last-scans']);
  }

  onLogoutClick() {
    this.loginService.logout();
  }

  onFileChange(event: Event) {
    const input = event.target as HTMLInputElement;
    if (input.files && input.files[0]) {
      const reader = new FileReader();
      reader.onload = (e) => {
        this.photo = (e.target as FileReader).result;
        this.router.navigate(['/result-page']);
        this.photoService.uploadPhoto(this.photo).subscribe();
      };
      reader.readAsDataURL(input.files[0]);
    }
  }
}
