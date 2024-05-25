import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LastScansComponent } from './last-scans.component';

describe('LastScansComponent', () => {
  let component: LastScansComponent;
  let fixture: ComponentFixture<LastScansComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [LastScansComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(LastScansComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
