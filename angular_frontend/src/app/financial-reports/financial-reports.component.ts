import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { EmployeeService } from '../services/employee.service';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-financial-reports',
  standalone: true,
  imports: [FormsModule, NgFor],
  templateUrl: './financial-reports.component.html',
  styleUrl: './financial-reports.component.scss'
})
export class FinancialReportsComponent implements OnInit {
  reportData: any = {};
  financialReports: any[] = [];

  constructor(private employeeService: EmployeeService) { }

  ngOnInit(): void {
    this.loadFinancialReports();
  }

  generateFinancialReport(): void {
    this.employeeService.generateFinancialReport(this.reportData).subscribe(
      (response) => {
        console.log('Financial report generated successfully:', response);
        this.loadFinancialReports();
      },
      (error) => {
        console.error('Error generating financial report:', error);
      }
    );
  }

  loadFinancialReports(): void {
    this.employeeService.getAllFinancialReports().subscribe(
      (data) => {
        this.financialReports = data;
      },
      (error) => {
        console.error('Error loading financial reports:', error);
      }
    );
  }
}
