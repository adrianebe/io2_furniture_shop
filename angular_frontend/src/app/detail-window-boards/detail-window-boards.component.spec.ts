import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailWindowBoardsComponent } from './detail-window-boards.component';

describe('DetailWindowBoardsComponent', () => {
  let component: DetailWindowBoardsComponent;
  let fixture: ComponentFixture<DetailWindowBoardsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DetailWindowBoardsComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DetailWindowBoardsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
