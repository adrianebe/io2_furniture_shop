import { Component } from '@angular/core';
import { DetailWindowComponent } from '../detail-window/detail-window.component';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-living-room',
  standalone: true,
  imports: [DetailWindowComponent, NgIf, NgFor],
  templateUrl: './living-room.component.html',
  styleUrl: './living-room.component.scss'
})
export class LivingRoomComponent {

}
