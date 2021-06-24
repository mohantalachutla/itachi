import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ChatComponentComponent } from './chat-component/chat-component.component';
import { MessageAreaComponent } from './message-area/message-area.component';
import { PageNotFoundComponent } from './page-not-found/page-not-found.component';


const routes: Routes = [
  {
    path: 'auth', loadChildren: () => import('./auth/auth.module').then(m => m.AuthModule).catch(e => console.log(e))
  },
  {
    path: 'area', component: MessageAreaComponent
  },
  {
    path: 'chat', component: ChatComponentComponent
  },
  { path: '', redirectTo: '/chat', pathMatch: 'full' },
  { path: '**', component:PageNotFoundComponent },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
exports: [RouterModule]
})
export class AppRoutingModule { }

