import { Component } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { EmployeeService } from '../services/employee.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-add-product',
  standalone: true,
  imports: [FormsModule, NgIf],
  templateUrl: './add-product.component.html',
  styleUrl: './add-product.component.scss'
})
export class AddProductComponent {
  product: any = {};
  error: string | null = null;

  constructor(private employeeService: EmployeeService, private router: Router) {}

  onSubmit(): void {
    this.employeeService.addAssortment(this.product).subscribe(
      addedProduct => {
        console.log('Produkt został dodany pomyślnie.');
        console.log(this.product);
        if (this.product.roomType === 'livingRoom') {
          this.router.navigate(["/living_room"]);
        } else {
        this.router.navigate(["/", this.product.roomType]);
        }
      },
      error => {
        console.error('Błąd podczas dodawania produktu:', error);
      }
    );
  }
}
