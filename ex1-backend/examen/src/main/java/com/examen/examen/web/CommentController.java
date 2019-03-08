package com.examen.examen.web;

import com.examen.examen.domain.Comment;
import com.examen.examen.service.CommentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService service;

    public CommentController (CommentService service) {
        this.service = service;
    }

    @PostMapping("/register-comment")
    public ResponseEntity<String> registerComment(@RequestBody Comment comment){
        service.saveComment(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update-comment")
    public ResponseEntity<String> updateComment(@RequestBody Comment comment){
        service.updateComment(comment);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find-all")
    public List<Comment> findAllComments(){
        return service.findAllComments();
    }


}
