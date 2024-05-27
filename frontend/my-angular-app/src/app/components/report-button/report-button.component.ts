import {Component, Input} from '@angular/core';
import {Router} from "@angular/router";

@Component({
  selector: 'app-report-button',
  templateUrl: './report-button.component.html',
  styleUrl: './report-button.component.css'
})
export class ReportButtonComponent {
  @Input() image: string | ArrayBuffer | null ='';

  constructor(private router: Router) {
  }

  onReportClick(): void {
    this.router.navigate(['/report-page', this.image]);
  }
}
