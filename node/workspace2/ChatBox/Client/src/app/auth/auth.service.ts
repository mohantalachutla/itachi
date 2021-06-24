import { Injectable } from '@angular/core';
@Injectable({
  providedIn: 'root'
})
export class AuthService {

  private _host:string = 'http://localhost:8080';
  constructor() { }
  register(user:{mail:string,pass:string})
  {
    let _url:string = `${this._host}/auth/register`;
    // false authentications
    return { ...user, response: {status:200,message:''}}
  }
  login(user:{mail:string,pass:string}){
    return { ...user, response: {status:200,message:''}};
  }
}
