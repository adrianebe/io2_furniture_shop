import { Component } from '@angular/core';
import { DetailWindowBoardsComponent } from '../detail-window-boards/detail-window-boards.component';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-boards',
  standalone: true,
  imports: [DetailWindowBoardsComponent, NgFor, NgIf],
  templateUrl: './boards.component.html',
  styleUrl: './boards.component.scss'
})
export class BoardsComponent {

}
