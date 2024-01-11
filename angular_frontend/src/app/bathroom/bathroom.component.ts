import { Component } from '@angular/core';
import { DetailWindowComponent } from '../detail-window/detail-window.component';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-bathroom',
  standalone: true,
  imports: [DetailWindowComponent, NgFor, NgIf],
  templateUrl: './bathroom.component.html',
  styleUrl: './bathroom.component.scss'
})
export class BathroomComponent {

}
