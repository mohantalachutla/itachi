import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  template: `
  <header><h1>Todo List</h1></header>
  `,
  styles: [`
  `,]
})
export class HeaderComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
