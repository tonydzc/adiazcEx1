package com.examen.examen.web;

import com.examen.examen.domain.Post;
import com.examen.examen.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    private final PostService service;

    public PostController (PostService service) {
        this.service = service;
    }

    @PostMapping("/register-post")
    public ResponseEntity<String> registerPost(@RequestBody Post post){
        service.savePost(post);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find-Nickname")
    public List <Post> findByNickname(@RequestParam("nickname") String nickname){
        return service.findByNickname(nickname);
    }

    @GetMapping("/find-all")
    public List<Post> findAllPosts(){
        return service.findAllPosts();
    }

}
