import { Component, OnInit } from '@angular/core';
import { DetailWindowComponent } from '../detail-window/detail-window.component';
import { NgFor, NgIf } from '@angular/common';
import { AssortmentService } from '../services/assortment.service';

@Component({
  selector: 'app-bathroom',
  standalone: true,
  imports: [DetailWindowComponent, NgFor, NgIf],
  templateUrl: './bathroom.component.html',
  styleUrl: './bathroom.component.scss'
})
export class BathroomComponent implements OnInit {
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
        this.assortmentData = data.filter(item => item.roomType === 'bathroom');
        console.log(this.assortmentData)
      },
      (error) => {
        console.error('Error loading assortment data:', error);
      }
    );
    }
  }
