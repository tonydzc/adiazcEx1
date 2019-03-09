package com.examen.examen.service;

import com.examen.examen.domain.User;
import com.examen.examen.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) { this.repository = repository; }

    @Transactional
    public void saveUser(User user){
        repository.saveAndFlush(user);
    }

    @Transactional
    public void updateUser(User user){
        Optional<User> examenUser = repository.findById(user.getId());
        User tempUser = examenUser.get();
        user.setId(tempUser.getId());
        repository.saveAndFlush(user);
    }

    @Transactional(readOnly = true)
    public List<User> findAllUsers(){
        return repository.findAll();
    }


    @Transactional
    public User findByNickname(String nickname){
        return repository.findByNickname(nickname);
    }

}
