import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AssortmentService } from '../services/assortment.service';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-detail-product',
  standalone: true,
  imports: [NgIf],
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
    this.assortmentService.getAssortmentById(id).subscribe(
      (data) => {
        console.log(data, id)
        this.assortmentItem = data;

      },
      (error) => {
        console.error('Error loading assortment item:', error);
      }
    );
  }
}
