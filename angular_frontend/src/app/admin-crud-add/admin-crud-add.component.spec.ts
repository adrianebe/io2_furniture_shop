import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCrudAddComponent } from './admin-crud-add.component';

describe('AdminCrudAddComponent', () => {
  let component: AdminCrudAddComponent;
  let fixture: ComponentFixture<AdminCrudAddComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdminCrudAddComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AdminCrudAddComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
