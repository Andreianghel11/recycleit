import { Component } from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-map-button',
  templateUrl: './map-button.component.html',
  styleUrl: './map-button.component.css'
})
export class MapButtonComponent {

  constructor(private router: Router) {
  }

  onMapClick(): void {
    this.router.navigate(['/map']);
  }
}
