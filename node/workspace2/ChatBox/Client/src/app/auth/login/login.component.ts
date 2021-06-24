import { Component, OnInit, TemplateRef } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import {Router, ActivatedRoute} from '@angular/router'
import { AuthService } from '../auth.service';


/**
 * reactive form which use rxjs, allows us to use validations
 * FormControl ,FormGroup,FormArray,  FormBuilder is builder which returns group,array, control
 * [formControl], formControlName, [formGroup], formGroupName
 */
@Component({
  selector: 'app-login',
  template: `
    <form #formLoginRef class= "card" [formGroup]="user">
        <div class="card-body">
          <div class="form-floating">
            <input type="mail" name="mail" id="mail"  class="form-control" formControlName="mail" placeholder="" required/>
            <label for="mail"> Enter your mail </label>
            <small class="text-danger" *ngIf="user?.get('mail')?.touched && user?.get('mail')?.invalid"> Mail is required</small>
          </div>

          <div class="form-floating">
            <input type="password" name="pass" id="pass"  class="form-control" formControlName="pass" placeholder="" required/>
            <label for="pass"> Enter password </label>
            <small class="text-danger" *ngIf="user?.get('pass')?.touched && user?.get('mail')?.invalid"> Password is required</small>
          </div>
        </div>
        <div class="card-footer">
          <button type="submit" (click)="formSubmit()" class= "btn btn-primary" [disabled]="user.invalid">Login</button>
        </div>
      </form>
      <!--{{user.value | json}}-->
  `,
  styles: [
  ]
})
export class LoginComponent implements OnInit {
  constructor(private readonly router:Router,private readonly route:ActivatedRoute, private readonly authService:AuthService) { }

  user = new FormBuilder().group(
    {
      mail: ['', Validators.required],
      pass: ['', Validators.required]
    }
  );

  // is equivalent to
  user1 = new FormGroup({mail:new FormControl(''), pass: new FormControl('')});

  ngOnInit(): void {
    
  }
  formSubmit(){
    let loginResponse =this.authService.login({mail:this.user.get('mail')?.value,pass:this.user.get('pass')?.value});
    
  }
}
