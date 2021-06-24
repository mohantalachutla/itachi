import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-chat-component',
  template: `
    <aside class="container  w-100 h-100 overflow-hidden p-0 m-0" style="">
      <div class="row position-fixed top-0 start-0 w-100" style="hieght:38px">
        <div class="col">
          <div class="navbar bg-secondary" style="">
          <span class="nav-brand">
            Other
          </span>
        </div>
        </div>
      </div>
      <div class="row position-absolute w-100" style="top:40px; left:0px; padding-bottom:40px;">
        <div class="col py-1">
          <app-message-area> </app-message-area>
        </div>
      </div>
      <div class="row position-fixed bottom-0 start-0 w-100" style="">
        <div class="col">
          <app-message-input> </app-message-input>
        </div>
      </div>
    </aside>
  `,
  styles: [
  ]
})
export class ChatComponentComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }

}
