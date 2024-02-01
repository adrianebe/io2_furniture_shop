import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmployeeService } from '../services/employee.service';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-edit-complaint',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './edit-complaint.component.html',
  styleUrl: './edit-complaint.component.scss'
})
export class EditComplaintComponent implements OnInit {
  complaintId!: number;
  complaintData: any = {};

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private employeeService: EmployeeService
  ) { }

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      this.complaintId = +params['id'];
    });

    this.employeeService.getComplaintById(this.complaintId).subscribe(
      (data) => {
        this.complaintData = data;
        console.log(data);

      },
      (error) => {
        console.error('Error loading complaint data:', error);
      }
    );
  }

  updateComplaint(): void {
    this.employeeService.updateComplaint(this.complaintId, this.complaintData).subscribe(
      (response) => {
        console.log('Complaint updated successfully:', response);
        this.router.navigate(['/complaints/list']);
      },
      (error) => {
        console.error('Error updating complaint:', error);
      }
    );
  }
}
