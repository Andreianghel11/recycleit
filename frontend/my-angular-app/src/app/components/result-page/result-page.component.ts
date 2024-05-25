import { Component } from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {PhotoService} from "../../services/photo.service";
import {WasteItemDto} from "../../dtos/wasteItem.dto";
import {RecyclingFactDto} from "../../dtos/recyclingFact.dto";

@Component({
  selector: 'app-result-page',
  templateUrl: './result-page.component.html',
  styleUrl: './result-page.component.css'
})
export class ResultPageComponent {
  imageUrl: string | ArrayBuffer | null = null;
  result: WasteItemDto | null = null;
  recylingFactDto: RecyclingFactDto | null = null;

  constructor(private photoService: PhotoService) {}

  ngOnInit(): void {
    this.photoService.result$.subscribe(data => {
      this.imageUrl = data.imageUrl;
      this.result = data.result;

      if (this.result && this.result.name) {
        this.getRandomRecyclingFact(this.result.name);
      }
    });
  }

  getRandomRecyclingFact(wasteItemName: string)  {
    this.photoService.getRandomRecyclingFact(wasteItemName).subscribe(data => {
      this.recylingFactDto = data;
    });
  }
}
