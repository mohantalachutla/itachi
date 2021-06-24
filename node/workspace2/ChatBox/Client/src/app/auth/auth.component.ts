import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-auth',
  template: `
    <div class="container mt-5" style="max-width:500px">
      <ul class="nav nav-tabs nav-fill">
        <li class="nav-item">
          <a class="nav-link" [class.active]="!isNewUser" (click)="isNewUser=false">Login</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" [class.active]="isNewUser" (click)="isNewUser=true">Register</a>
        </li>
      </ul>
      <app-login *ngIf="!isNewUser"></app-login>
      <app-register *ngIf="isNewUser"> </app-register>
    <div>
  `,
  styles: [
  ]
})
export class AuthComponent implements OnInit {

  constructor() { }

  isNewUser=false;

  ngOnInit(): void {
  }
}
