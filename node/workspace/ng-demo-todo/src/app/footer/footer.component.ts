import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  template: `
  <p>main works! {{mainService.getMessage()}}</p>
  `,
  styles: [`
  
  `]
})
export class FooterComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
