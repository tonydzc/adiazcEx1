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
    public Comment findById(long id){
        return repository.findById(id).get();
    }

    @Transactional
    public void updateComment(Comment comment, Long id){
        Comment commentToUpdate= repository.findById(id).get();
        commentToUpdate.setComment(comment.getComment());
        commentToUpdate.setTimestamp(comment.getTimestamp());
        repository.saveAndFlush(commentToUpdate);
    }

    @Transactional(readOnly = true)
    public List<Comment> findAllComments(){
        return repository.findAll();
    }

}
