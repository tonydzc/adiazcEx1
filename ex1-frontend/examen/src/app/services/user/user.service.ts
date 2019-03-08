import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { User } from 'src/app/model/user.model';


@Injectable()
export class UserService {
  constructor(private http: HttpClient) { }
  

  getUsers(): Observable <any[]> {
    const url = 'http://localhost:8080/user/find-ll';
    return this.http.get<any[]>(url);
  }

  createUser(user: User){
    const url = 'http://localhost:8080/user/register-user';
    return this.http.post(url, user);
  }
  getUserById(id: String) {
    const url = 'http://localhost:8080/user/find-by-id';
    return this.http.get<User>(url + '/' + id);
  }

}
