import { Component } from '@angular/core';
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {ActivatedRoute, Router} from "@angular/router";
import {ImageFeedbackService} from "../../services/image-feedback.service";

@Component({
  selector: 'app-report-page',
  templateUrl: './report-page.component.html',
  styleUrl: './report-page.component.css'
})
export class ReportPageComponent {
  reportForm: FormGroup;
  options = [
    { label: 'Plastic', value: 'Plastic' },
    { label: 'Metal', value: 'Metal' },
    { label: 'Glass', value: 'Glass' },
    { label: 'Cardboard', value: 'Cardboard' },
    { label: 'Biological', value: 'Biological' },
    { label: 'Battery', value: 'Battery' },
    { label: 'Paper', value: 'Paper' },
    { label: 'Shoes', value: 'Shoes' },
    { label: 'Clothes', value: 'Clothes' },
    { label: 'Trash', value: 'Trash' },
  ];
  warningMessage: string = '';
  image: string | ArrayBuffer | null = '';

  constructor(private fb: FormBuilder, private router: Router, private route: ActivatedRoute, private imageFeedbackService: ImageFeedbackService) {
    this.reportForm = this.fb.group({
      selectedOption: ['', Validators.required]
    });
  }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.image = params['image'];
    });
  }

  onSubmit(): void {
    if (this.reportForm.valid) {
      const selectedOption = this.reportForm.value.selectedOption;
      this.imageFeedbackService.addImageFeedback(selectedOption, this.image);
      this.warningMessage = '';
      this.router.navigate(['/menu']);
    } else {
      this.warningMessage = 'Please select an option';
    }
  }
}
