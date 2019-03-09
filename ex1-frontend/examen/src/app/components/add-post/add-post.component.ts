import { Component, OnInit } from '@angular/core';
import {Router} from "@angular/router";
import {FormBuilder, FormGroup, Validators, NgForm}  from '@angular/forms';
import { PostService } from 'src/app/services/post.service';
import { Post } from 'src/app/model/post';

@Component({
  selector: 'app-add-post',
  templateUrl: './add-post.component.html',
  styleUrls: ['./add-post.component.scss']
})
export class AddPostComponent implements OnInit {

  post: Post = new Post();

  addform : FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router, private postService: PostService) {

  }
  createPost(): void {
    this.postService.createPost(this.post)
        .subscribe( data => {
          alert("Post created successfully.");
        });

  };

  ngOnInit() {
    this.addform = this.formBuilder.group({
      title: ['', Validators.required],
      text: ['', Validators.required],
    });

  }

  onSubmit() {
    this.post.title=this.addform.value.title;
    this.post.text=this.addform.value.text;
    this.post.timestamp= new Date();
    this.createPost();
  }

}
