import { Component, OnInit } from '@angular/core';
import {MainService} from './main.service';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.scss']
})
export class MainComponent implements OnInit {
  constructor(mainService:MainService) { this.mainService=mainService}
  mainService;
  ngOnInit(): void {
    console.log(this.mainService.getMessage());
  }
}
