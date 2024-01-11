import { Component } from '@angular/core';
import { DetailWindowComponent } from '../detail-window/detail-window.component';

@Component({
  selector: 'app-living-room',
  standalone: true,
  imports: [DetailWindowComponent],
  templateUrl: './living-room.component.html',
  styleUrl: './living-room.component.scss'
})
export class LivingRoomComponent {

}
