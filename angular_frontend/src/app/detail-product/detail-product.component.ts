import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AssortmentService } from '../services/assortment.service';

@Component({
  selector: 'app-detail-product',
  standalone: true,
  imports: [],
  templateUrl: './detail-product.component.html',
  styleUrl: './detail-product.component.scss'
})
export class DetailProductComponent implements OnInit{
  assortmentItem: any;

  constructor(
    private route: ActivatedRoute,
    private assortmentService: AssortmentService
  ) {}

  ngOnInit(): void {
    this.route.params.subscribe(params => {
      const id = params['id'];
      if (id) {
        this.loadAssortmentItem(id);
      }
    });
  }

  loadAssortmentItem(id: number): void {
    this.assortmentService.getAssortment().subscribe(
      (data) => {
        console.log(data)
        this.assortmentItem = data.find(item => item.id === id);

      },
      (error) => {
        console.error('Error loading assortment item:', error);
      }
    );
  }
}
