import { Component, OnInit } from '@angular/core';
import { DetailWindowComponent } from '../detail-window/detail-window.component';
import { NgFor, NgIf } from '@angular/common';
import { AssortmentService } from '../services/assortment.service';

@Component({
  selector: 'app-bedroom',
  standalone: true,
  imports: [NgFor, NgIf, DetailWindowComponent],
  templateUrl: './bedroom.component.html',
  styleUrl: './bedroom.component.scss'
})
export class BedroomComponent implements OnInit {
  assortmentData!: any[];

  constructor(private assortmentService: AssortmentService) {}

  ngOnInit(): void {
    this.loadAssortmentData();
  }

  loadAssortmentData(): void {
    this.assortmentService.getAssortment().subscribe(
      (data) => {
        this.assortmentData = data.filter(item => item.roomType === 'bedroom');
        console.log(this.assortmentData)
      },
      (error) => {
        console.error('Error loading assortment data:', error);
      }
    );
    }
  }
