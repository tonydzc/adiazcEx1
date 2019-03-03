package com.examen.examen.service;

import com.examen.examen.domain.Comment;
import com.examen.examen.repository.CommentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CommentService {

    private final CommentRepository repository;

    public CommentService(CommentRepository repository) { this.repository = repository; }

    @Transactional
    public void saveComment(Comment comment){
        repository.saveAndFlush(comment);
    }

    @Transactional
    public void updateComment(Comment comment){
        Optional<Comment> examenComment = repository.findById(comment.getId());
        Comment tempComment = examenComment.get();
        comment.setId(tempComment.getId());
        repository.saveAndFlush(comment);
    }

    @Transactional(readOnly = true)
    public List<Comment> findAllComments(){
        return repository.findAll();
    }

}
