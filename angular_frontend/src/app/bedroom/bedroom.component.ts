import { Component } from '@angular/core';
import { DetailWindowComponent } from '../detail-window/detail-window.component';

@Component({
  selector: 'app-bedroom',
  standalone: true,
  imports: [DetailWindowComponent],
  templateUrl: './bedroom.component.html',
  styleUrl: './bedroom.component.scss'
})
export class BedroomComponent {

}
