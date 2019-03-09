import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { LoginComponent } from './components/login/login.component';
import { AddUserComponent } from './components/add-user/add-user.component';
import {HttpClientModule} from "@angular/common/http";
import {ReactiveFormsModule} from "@angular/forms";
import { UserService } from './services/user.service';
import { AuthService } from './services/auth.service';
import { MenuComponent } from './components/menu/menu.component';
import { AddPostComponent } from './components/add-post/add-post.component';
import { PostService } from './services/post.service';
import { AddCommentComponent } from './components/add-comment/add-comment.component';
import { CommentService } from './services/comment.service';
import { PostComponent } from './components/post/post.component';
import { HomeComponent } from './components/home/home.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    AddUserComponent,
    MenuComponent,
    AddPostComponent,
    AddCommentComponent,
    PostComponent,
    HomeComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [AuthService, UserService, PostService, CommentService],
  bootstrap: [AppComponent]
})
export class AppModule { }
