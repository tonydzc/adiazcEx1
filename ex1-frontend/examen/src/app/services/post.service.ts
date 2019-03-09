import { Injectable } from '@angular/core';
import { Post } from '../model/post';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable()
export class PostService {
  constructor(private http: HttpClient) { }
  

  getPosts(): Observable <any[]> {
    const url = 'http://localhost:8080/post/find-all';
    return this.http.get<any[]>(url);
  }

  createPost(user: Post){
    const url = 'http://localhost:8080/post/register-post';
    return this.http.post(url, user);
  }
  getPostById(id: String) {
    const url = 'http://localhost:8080/post/find-by-id';
    return this.http.get<Post>(url + '/' + id);
  }

}
