import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Comment } from '../model/comment'

@Injectable()
export class CommentService {

  constructor(private http: HttpClient) { }

  
  getComents(): Observable <any[]> {
    const url = 'http://localhost:8080/comment/find-all';
    return this.http.get<any[]>(url);
  }

  createComment(comment: Comment){
    const url = 'http://localhost:8080/comment/register-comment';
    return this.http.post(url, comment);
  }

  editComment(comment: Comment){
    const url = 'http://localhost:8080/comment/update-comment';
    return this.http.post(url, comment);
  }
  getUserById(id: String) {
    const url = 'http://localhost:8080/comment/find-by-id';
    return this.http.get<Comment>(url + '/' + id);
  }
} 
