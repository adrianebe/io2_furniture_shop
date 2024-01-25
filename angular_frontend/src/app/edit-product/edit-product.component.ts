import { Component, OnInit } from '@angular/core';
import { FormsModule, NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { AssortmentService } from '../services/assortment.service';
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
    private route: ActivatedRoute,
    private router: Router
  ) {}

  ngOnInit(): void {
    const productId = this.route.snapshot.paramMap.get('id');
    if (productId) {
      this.assortmentService.getAssortmentById(Number(productId)).subscribe(
        (productData) => {
          this.product = productData;
          console.log(this.product)
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
    this.assortmentService.updateAssortment(this.product.productId, this.product).subscribe(
      (updatedProduct) => {
        console.log('Produkt został zaktualizowany pomyślnie.', updatedProduct);
        if (this.product.roomType === 'livingRoom') {
          this.router.navigate(["/living_room"]);
        } else {
          this.router.navigate(["/", this.product.roomType]);
        }
      },
      (error) => {
        console.error('Błąd podczas aktualizacji produktu:', error);
      }
    );
  }
}
