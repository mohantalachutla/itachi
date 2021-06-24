import { Injectable, Inject } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MainService {

  constructor() { }
  getMessage()
  {
    return "Hi itachi";
  }
}
