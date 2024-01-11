import { Component } from '@angular/core';
import { AssortmentService } from '../services/assortment.service';
import { Assortment } from '../DTO/assortment';
import { DetailWindowComponent } from '../detail-window/detail-window.component';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-kitchen',
  standalone: true,
  imports: [DetailWindowComponent, NgFor, NgIf],
  templateUrl: './kitchen.component.html',
  styleUrl: './kitchen.component.scss'
})
export class KitchenComponent {

  assortment: Assortment[];

  constructor(private assortmentService: AssortmentService) {
    this.assortment = [];
  }

  ngOnInit() {
    this.assortmentService.getAssortment().subscribe((data: any[]) => {
      this.assortment = data;
    });
  }
}
