import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminCrudEditComponent } from './admin-crud-edit.component';

describe('AdminCrudEditComponent', () => {
  let component: AdminCrudEditComponent;
  let fixture: ComponentFixture<AdminCrudEditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdminCrudEditComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(AdminCrudEditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
