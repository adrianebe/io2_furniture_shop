import { Component } from '@angular/core';
import { DetailWindowComponent } from '../detail-window/detail-window.component';

@Component({
  selector: 'app-bathroom',
  standalone: true,
  imports: [DetailWindowComponent],
  templateUrl: './bathroom.component.html',
  styleUrl: './bathroom.component.scss'
})
export class BathroomComponent {

}
