import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { MessageInputComponent } from './message-input/message-input.component';
import { MessageAreaComponent } from './message-area/message-area.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';
import { ChatComponentComponent } from './chat-component/chat-component.component';
import { ChatListComponetComponent } from './chat-list-componet/chat-list-componet.component';

@NgModule({
  declarations: [
    AppComponent,
    MessageInputComponent,
    MessageAreaComponent,
    PageNotFoundComponent,
    ChatComponentComponent,
    ChatListComponetComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
