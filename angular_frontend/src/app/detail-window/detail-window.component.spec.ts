import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailWindowComponent } from './detail-window.component';

describe('DetailWindowComponent', () => {
  let component: DetailWindowComponent;
  let fixture: ComponentFixture<DetailWindowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DetailWindowComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DetailWindowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
