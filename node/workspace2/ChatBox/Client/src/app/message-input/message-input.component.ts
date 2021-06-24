import { Component, EventEmitter, OnInit,Output } from '@angular/core';

@Component({
  selector: 'app-message-input',
  template: `
  <form (ngSubmit)="sendMessage()">
    <div class="d-flex w-100">
      <input type="text" name="msg" class="input-control w-100" [(ngModel)]="msg" placeholder="Enter a message"/>
      <input type="submit" class="btn btn-primary float-end" value="send"/>
    </div>
  </form>
  `,
  styles: [
  ]
})
export class MessageInputComponent implements OnInit {

  constructor() { }
  msg: string = "";
  @Output() message = new EventEmitter();
  ngOnInit(): void {
  }
  sendMessage() {   
    console.log(`msg: ${this.msg}`);
    this.emitMessage(this.msg);
  }
  emitMessage(msg: String) {
    this.message.emit(msg);
  }

}
