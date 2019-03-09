import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators, NgForm} from "@angular/forms";
import { User } from 'src/app/model/user.model';
import { UserService } from 'src/app/services/user.service';

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
      nickname: ['', Validators.required]
    });

  }

  onSubmit() {
    this.user.nickname=this.addform.value.nickname;
    console.log(this.addform.value.nickname);
    this.createUser();
  }

}
