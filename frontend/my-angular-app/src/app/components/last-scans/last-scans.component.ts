import { Component } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {RecyclingHistoryUserDto} from "../../dtos/recyclingHistoryUser.dto";
import {Observable} from "rxjs";
import {RecyclingHistoryService} from "../../services/recycling-history.service";
import {MatDialog} from "@angular/material/dialog";
import {ConfirmationDialogComponent} from "../confirmation-dialog/confirmation-dialog.component";

@Component({
  selector: 'app-last-scans',
  templateUrl: './last-scans.component.html',
  styleUrl: './last-scans.component.css'
})
export class LastScansComponent {
  recyclingHistory: RecyclingHistoryUserDto[] = [];
  page = 0;
  size = 8;
  totalPages = 0;

  constructor(private recyclingHistoryService: RecyclingHistoryService, public dialog: MatDialog) { }

  ngOnInit(): void {
    this.loadRecyclingHistory();
  }

  loadRecyclingHistory(): void {
    this.recyclingHistoryService.getRecyclingHistoryUser(this.page, this.size).subscribe(data => {
      this.recyclingHistory = data.content;
      this.totalPages = data.totalPages;
      console.log('Recycling history:', this.recyclingHistory);
    }, error => {
      console.error('Error fetching recycling history:', error);
    });
  }

  nextPage(): void {
    if (this.page < this.totalPages - 1) {
      this.page++;
      this.loadRecyclingHistory();
    }
  }

  previousPage(): void {
    if (this.page > 0) {
      this.page--;
      this.loadRecyclingHistory();
    }
  }

  deleteRecyclingHistory(id : number) {
    console.log('Deleting recycling history item with id:', id);
    this.recyclingHistoryService.deleteRecyclingHistory(id);
    this.recyclingHistory = this.recyclingHistory.filter(item => item.id !== id);
  }

  openConfirmationDialog(id: number): void {
    const dialogRef = this.dialog.open(ConfirmationDialogComponent);

    dialogRef.afterClosed().subscribe(result => {
      if (result) {
        this.deleteRecyclingHistory(id);
      }
    });
  }
}
