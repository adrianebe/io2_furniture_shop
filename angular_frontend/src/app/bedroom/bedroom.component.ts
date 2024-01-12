import { Component } from '@angular/core';
import { DetailWindowComponent } from '../detail-window/detail-window.component';
import { NgFor, NgIf } from '@angular/common';
import { Assortment } from '../DTO/assortment';


@Component({
  selector: 'app-bedroom',
  standalone: true,
  imports: [NgFor, NgIf, DetailWindowComponent],
  templateUrl: './bedroom.component.html',
  styleUrl: './bedroom.component.scss'
})
// id: number;
// name: string;
// type: string;
// roomType: string;
// price: number;
// description: string;
// availability: number;
export class BedroomComponent {
  products: Assortment[] = [
    {id: 1, name: 'krzeslo', type: 'furniture', roomType: 'bedroom', price: 100, description: 'opis krzesla', availability: 1},
    {id: 2, name: 'krzeslo2', type: 'furniture', roomType: 'bedroom', price: 1020, description: 'opis krzesla2', availability: 1},
    {id: 3, name: 'krzeslo3', type: 'furniture', roomType: 'bedroom', price: 1040, description: 'opis krzesla3', availability: 0},
  ];
}
