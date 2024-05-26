import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {RecyclingHistoryUserDto} from "../../dtos/recyclingHistoryUser.dto";
import {Observable} from "rxjs";
import {RecyclingHistoryService} from "../../services/recycling-history.service";

@Component({
  selector: 'app-last-scans',
  templateUrl: './last-scans.component.html',
  styleUrl: './last-scans.component.css'
})
export class LastScansComponent {
  recyclingHistory: RecyclingHistoryUserDto[] = [];

  constructor(private recyclingHistoryService: RecyclingHistoryService) { }

  ngOnInit(): void {
    this.recyclingHistoryService.getRecyclingHistoryUser().subscribe(data => {
      this.recyclingHistory = data.reverse();
      console.log('Recycling history:', this.recyclingHistory);
    }, error => {
      console.error('Error fetching recycling history:', error);
    });
  }
}
