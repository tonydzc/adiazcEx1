package com.examen.examen.service;

import com.examen.examen.domain.Post;
import com.examen.examen.repository.PostRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PostService {

    private final PostRepository repository;

    public PostService(PostRepository repository) { this.repository = repository; }

    @Transactional
    public void savePost(Post post){
        repository.saveAndFlush(post);
    }

    @Transactional
    public void updatePost(Post post){
        Optional<Post> examenPost = repository.findById(post.getId());
        Post tempPost = examenPost.get();
        post.setId(tempPost.getId());
        repository.saveAndFlush(post);
    }

    @Transactional
    public Post findById(long id){
        return repository.findById(id).get();
    }

    @Transactional
    public List <Post> findByNickname(String nickname){
        return repository.findByNickname(nickname);
    }

    @Transactional(readOnly = true)
    public List<Post> findAllPosts(){
        return repository.findAll();
    }

}
