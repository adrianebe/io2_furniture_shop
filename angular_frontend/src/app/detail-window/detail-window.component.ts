import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-detail-window',
  standalone: true,
  imports: [],
  templateUrl: './detail-window.component.html',
  styleUrl: './detail-window.component.scss'
})
export class DetailWindowComponent implements OnInit{
  @Input() assortmentItem: any;

  ngOnInit(): void {

  }
}
