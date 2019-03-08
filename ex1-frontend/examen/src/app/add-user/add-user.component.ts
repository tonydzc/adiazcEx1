import { Component, OnInit } from '@angular/core';
import {first} from "rxjs/operators";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators, NgForm} from "@angular/forms";
import {UserService} from "../services/user/user.service";
import { User } from '../model/user.model';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.scss']
})
export class AddUserComponent implements OnInit {

  user: User = new User();

  addform : FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router, private userService: UserService) {

  }
  createUser(): void {
    this.userService.createUser(this.user)
        .subscribe( data => {
          alert("User created successfully.");
        });

  };

  ngOnInit() {
   
    this.addform = this.formBuilder.group({
      nickname: ['', Validators.required],
      status: ['', Validators.required],
    });

  }

  onSubmit() {
    this.user.id='12';
    this.user.nickname=this.addform.value.nickname;
    this.user.status=this.addform.value.status;
    console.log(this.addform.value.nickname);
  }

}
