import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LevelAndBadgesComponent } from './level-and-badges.component';

describe('LevelAndBadgesComponent', () => {
  let component: LevelAndBadgesComponent;
  let fixture: ComponentFixture<LevelAndBadgesComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LevelAndBadgesComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LevelAndBadgesComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
