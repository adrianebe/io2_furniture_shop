import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DetailFinancialReportComponent } from './detail-financial-report.component';

describe('DetailFinancialReportComponent', () => {
  let component: DetailFinancialReportComponent;
  let fixture: ComponentFixture<DetailFinancialReportComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [DetailFinancialReportComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(DetailFinancialReportComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
