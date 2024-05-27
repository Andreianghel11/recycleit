import { TestBed } from '@angular/core/testing';

import { ImageFeedbackService } from './image-feedback.service';

describe('ImageFeedbackService', () => {
  let service: ImageFeedbackService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ImageFeedbackService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
