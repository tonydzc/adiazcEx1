import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent} from "./components/login/login.component";
import { AddUserComponent} from "./components/add-user/add-user.component";
import { AddPostComponent } from "./components/add-post/add-post.component";
import { AddCommentComponent } from "./components/add-comment/add-comment.component"
import { PostComponent } from './components/post/post.component';
import { HomeComponent } from './components/home/home.component';


const routes: Routes = [
      {
        path:'login', component: LoginComponent
      },
      { 
        path: 'user', component: AddUserComponent 
      },
      {
        path : '', component : LoginComponent
      },
      {
        path : 'post', component : AddPostComponent
      },
      {
        path : 'comment', component : AddCommentComponent
      },
      {
        path : 'post', component : PostComponent
      },
      {
        path : 'home', component : HomeComponent
      }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
