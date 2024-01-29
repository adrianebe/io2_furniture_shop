import { Component, OnInit } from '@angular/core';
import { DetailWindowComponent } from '../detail-window/detail-window.component';
import { NgFor, NgIf } from '@angular/common';
import { AssortmentService } from '../services/assortment.service';

@Component({
  selector: 'app-kitchen',
  standalone: true,
  imports: [DetailWindowComponent, NgFor, NgIf],
  templateUrl: './kitchen.component.html',
  styleUrl: './kitchen.component.scss'
})
export class KitchenComponent implements OnInit {
  assortmentData!: any[];

  constructor(private assortmentService: AssortmentService) {}

  ngOnInit(): void {
    this.loadAssortmentData();
  }

  isEmployee(): boolean {
    const roles = localStorage.getItem('role');
    return roles === 'EMPLOYEE';
  }

  loadAssortmentData(): void {
    this.assortmentService.getAssortment().subscribe(
      (data) => {
        this.assortmentData = data.filter(item => item.roomType === 'kitchen');
        console.log(this.assortmentData)
      },
      (error) => {
        console.error('Error loading assortment data:', error);
      }
    );
    }
  }
