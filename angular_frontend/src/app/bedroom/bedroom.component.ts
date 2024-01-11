import { Component } from '@angular/core';
import { DetailWindowComponent } from '../detail-window/detail-window.component';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-bedroom',
  standalone: true,
  imports: [NgFor, NgIf, DetailWindowComponent],
  templateUrl: './bedroom.component.html',
  styleUrl: './bedroom.component.scss'
})
export class BedroomComponent {

}
