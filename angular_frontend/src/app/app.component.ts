import { AxiosLoginService } from './services/axios-login.service';
import { Component } from '@angular/core';
import { CommonModule, NgIf } from '@angular/common';
import { RouterOutlet } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, NgIf],
  templateUrl: './app.component.html',
  styleUrl: './app.component.scss'
})
export class AppComponent {

  constructor(public axios: AxiosLoginService) {}
  title = 'angular_frontend';
  onLogout(): void {
    console.log('Wylogowanie...');
    this.axios.logout();
  }

}
