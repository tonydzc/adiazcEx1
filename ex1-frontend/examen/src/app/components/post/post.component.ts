import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Post } from 'src/app/model/post';
import { PostService } from 'src/app/services/post.service';

@Component({
  selector: 'app-post',
  templateUrl: './post.component.html',
  styleUrls: ['./post.component.scss']
})
export class PostComponent implements OnInit {

  private posts : any;

  constructor(private router: Router, private postService : PostService) { }
  
  ngOnInit() {
    this.postService.getPosts()
      .subscribe( data => {
        this.posts = data;
      });
  }

}
