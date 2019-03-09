import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { Comment } from 'src/app/model/comment';
import { CommentService } from 'src/app/services/comment.service';


@Component({
  selector: 'app-add-comment',
  templateUrl: './add-comment.component.html',
  styleUrls: ['./add-comment.component.scss']
})
export class AddCommentComponent implements OnInit {

  comment: Comment = new Comment();

  addform : FormGroup;

  constructor(private formBuilder: FormBuilder, private router: Router, private commentService: CommentService) {

  }
  createPost(): void {
    this.commentService.createComment(this.comment)
        .subscribe( data => {
          alert("Comment created successfully.");
        });

  };

  editComment(): void {
    this.commentService.editComment(this.comment)
        .subscribe( data => {
          alert("Comment created successfully.");
        });

  };

  ngOnInit() {
    this.addform = this.formBuilder.group({
      comment: ['', Validators.required],
    });

  }

  onSubmit() {
    this.comment.comment=this.addform.value.comment;
    this.comment.timestamp= new Date();
    this.createPost();
  }
}
