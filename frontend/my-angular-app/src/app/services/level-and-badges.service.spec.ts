import { TestBed } from '@angular/core/testing';

import { LevelAndBadgesService } from './level-and-badges.service';

describe('LevelAndBadgesService', () => {
  let service: LevelAndBadgesService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(LevelAndBadgesService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
