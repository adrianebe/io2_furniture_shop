import { Component, OnInit } from '@angular/core';
import { DetailWindowComponent } from '../detail-window/detail-window.component';
import { NgFor, NgIf } from '@angular/common';
import { AssortmentService } from '../services/assortment.service';

@Component({
  selector: 'app-living-room',
  standalone: true,
  imports: [DetailWindowComponent, NgIf, NgFor],
  templateUrl: './living-room.component.html',
  styleUrl: './living-room.component.scss'
})
export class LivingRoomComponent implements OnInit {
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
        this.assortmentData = data.filter(item => item.roomType === 'livingRoom');
        console.log(this.assortmentData)
      },
      (error) => {
        console.error('Error loading assortment data:', error);
      }
    );
    }
  }

