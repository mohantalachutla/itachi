import { Component, OnInit } from '@angular/core';
import { TextMessage, User } from 'src/types/types';

@Component({
  selector: 'app-message-area',
  template: `
  <div class="container-fluid p-0 m-0">
    <div class="bg-dark p-0 m-0">
      <div class="d-inline-block w-100" *ngFor="let message of recentMessages()">
      <div class="card my-1 rounded-1"  [class]="message.createdBy===user.name ? classes.sender : classes.recipient" style="max-width:75%" [style]="message.createdBy===user.name ? styles.sender : styles.recipient ">
      <div class="card-header p-0" style="font-size:13px">
      <span class="card-title"> {{message.createdBy}}</span>
      </div>
      <label class="card-body p-0 m-0" style="font-size:15px;"> 
      {{message.text}}
      <sub style="font-size:10px;">{{message.createdOn | date:'shortTime'}} </sub>
      </label>
    </div>
      </div>
    </div>
  </div>
  `,
  styles: [
  ]
})
export class MessageAreaComponent implements OnInit {

  constructor() {}

  private messages:Array<TextMessage> = [];
  public user={mail:'mail@cs.com', name:'itachi'};
  public classes:{sender:Array<String>,recipient:Array<String>} = {sender:[],recipient:[]}
  public styles:{sender:Object,recipient:Object} = {sender:{},recipient:{}}

  ngOnInit(): void {
    this.messages= [
      {text:'hi',createdBy:'itachi',createdOn:new Date()},
      {text:'hi',createdBy:'recipient',createdOn:new Date()},
      {text:'how r doing',createdBy:'itachi',createdOn:new Date()},
      {text:'fine',createdBy:'recipient',createdOn:new Date()},
      {text:'u?',createdBy:'recipient',createdOn:new Date()},
      {text:'goodddfad',createdBy:'itachi',createdOn:new Date()},
      {text:'goosddfdd',createdBy:'recipient',createdOn:new Date()},
      {text:'asdfasdf',createdBy:'itachi',createdOn:new Date()},
      {text:'goossdfdfd',createdBy:'recipient',createdOn:new Date()},
      {text:'adeerdddd',createdBy:'itachi',createdOn:new Date()},
      {text:`oidsfielk jfaoiesdf a dfsd  wed  se df dfadf    dddf weelksdf lkeiopwsd  ddd fwe 
      lsdiof e
      kldfoel
      
      
      iefskc iiidowiodfow pkdlk`,createdBy:'recipient',createdOn:new Date()},
      {text:'adeerdddd',createdBy:'itachi',createdOn:new Date()},
      {text:'later?',createdBy:'itachi',createdOn:new Date()},
      {text:'now',createdBy:'recipient',createdOn:new Date()},
    ];

    this.classes = {sender:['bg-primary','text-light',],recipient:[] }
    this.styles={ sender:{'float':'right'}, recipient:{'float':'left'}}
  }
  recentMessages():Array<TextMessage>
  {
    return this.messages;
  }

}
