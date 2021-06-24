import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AuthService } from '../auth.service';
/**
 * ***keypoints***
 * template driven form:
 * ngForm reference to html form, using #templateref="ngForm" we can bind the data, templateref.value has all values of form controls
 * ngModel is to specify which input needs to be tracked, also used for input binding, [] prop binding: controller to template, () evenbiding: template to controller
*/
@Component({
  selector: 'app-register',
  template: `
    <div class="card">
      <form #formRegisterRef="ngForm" (ngSubmit)="submitForm()">
        <div class="card-body">
          <div class="form-floating">
            <input type="mail" name="mail" id="mail" #mail="ngModel" [(ngModel)]="user.mail" [class.is-invalid]="mail.errors && (mail.touched && mail.invalid)" class="form-control" placeholder="" required/>
            <label for="mail"> Enter your mail </label>
            <div class="text-danger" *ngIf="mail.touched && mail.invalid">
              <small *ngIf="mail.errors?.required"> Mail is required </small>
              <small *ngIf="mail.errors?.pattern"> Mail is invalid </small>
            </div>
          </div>

          <div class="form-floating">
            <input type="password" name="pass" id="pass" class="form-control" [class.is-invalid]="pass.touched && pass.invalid"  #pass="ngModel" [ngModel]="user.pass" placeholder="" required/>
            <label for="pass"> Enter password </label>
            <div class="text-danger" *ngIf="pass.touched && pass.invalid">
              <small *ngIf="pass.errors?.required"> Password is required </small>
              <small *ngIf="pass.errors?.pattern"> Password is invalid </small>
            </div>
          </div>
        </div>

        <div class="card-footer">
          <button type="submit" class="btn btn-primary" [disabled]="formRegisterRef.invalid">Register</button>
        </div>
      </form>
        <!--<hr>
        <span> formRegisterRef :</span>  {{formRegisterRef.value | json}}
        <hr>
        <span> user :</span>  {{user | json}}-->
    </div>
        `,
  styles: [
  ]
})
export class RegisterComponent implements OnInit {

  constructor(private readonly router: Router, private readonly route: ActivatedRoute, private readonly authService:AuthService) { }

  // private variables can not be accessed in templates
  user: { mail: string, pass: string } = { mail: '', pass: '' };

  ngOnInit(): void {
  }
  submitForm() {
    let loginResponse =this.authService.login(this.user);
  }
}
