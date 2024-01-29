import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AssortmentService } from '../services/assortment.service';
import { EmployeeService } from '../services/employee.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-edit-product',
  standalone: true,
  imports: [FormsModule, NgIf],
  templateUrl: './edit-product.component.html',
  styleUrl: './edit-product.component.scss'
})
export class EditProductComponent implements OnInit {
  product: any = {};
  error: string | null = null;

  constructor(
    private assortmentService: AssortmentService,
    private employeeService: EmployeeService,
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const productId = this.route.snapshot.paramMap.get('id');
    if (productId) {
      console.log(productId, this.product)
      this.assortmentService.getAssortmentById(Number(productId)).subscribe(
        (productData) => {
          this.product = productData;
        },
        (error) => {
          console.error('Błąd podczas pobierania danych produktu:', error);
        }
      );
    } else {
      console.error('Brak identyfikatora produktu w parametrze URL.');
    }
  }

  onSubmit(): void {
    this.employeeService.updateAssortment(this.product.id, this.product).subscribe(
      () => {
        console.log('Produkt został zaktualizowany pomyślnie.');
        if (this.product.roomType === 'livingRoom') {
          this.router.navigate(["/living_room"]);
        } else {
          this.router.navigate(["/", this.product.roomType]);
        }
      },
      (error) => {
        console.log(this.product)
        console.error('Błąd podczas aktualizacji produktu:', error);
      }
    );
  }
}
