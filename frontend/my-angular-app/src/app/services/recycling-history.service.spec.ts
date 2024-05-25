import { TestBed } from '@angular/core/testing';

import { RecyclingHistoryService } from './recycling-history.service';

describe('RecyclingHistoryService', () => {
  let service: RecyclingHistoryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RecyclingHistoryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
