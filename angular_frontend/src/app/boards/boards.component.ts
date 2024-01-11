import { Component } from '@angular/core';
import { DetailWindowBoardsComponent } from '../detail-window-boards/detail-window-boards.component';

@Component({
  selector: 'app-boards',
  standalone: true,
  imports: [DetailWindowBoardsComponent],
  templateUrl: './boards.component.html',
  styleUrl: './boards.component.scss'
})
export class BoardsComponent {

}
