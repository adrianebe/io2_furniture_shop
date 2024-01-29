import { AxiosLoginService } from './services/axios-login.service';
import { Component, OnInit } from '@angular/core';
import { Router, NavigationEnd } from '@angular/router';
import { CommonModule, NgIf } from '@angular/common';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, NgIf],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent implements OnInit {

  customHeightClass: string = 'default-height';

  constructor(public axios: AxiosLoginService, private router: Router) {}

  ngOnInit(): void {
    this.router.events.subscribe(event => {
      if (event instanceof NavigationEnd) {
        this.updateCustomHeightClass(event.url);
      }
    });
  }

  updateCustomHeightClass(url: string): void {
    if (url.includes('product/detail')) {
      this.customHeightClass = 'custom-height';
    } else {
      this.customHeightClass = 'default-height';
    }
  }
  title = 'angular_frontend';
  onLogout(): void {
    this.axios.logout();
  }

}
