package com.examen.examen.service;

import com.examen.examen.domain.Tag;
import com.examen.examen.repository.TagRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TagService {
    private final TagRepository repository;

    public TagService(TagRepository repository) { this.repository = repository; }

    @Transactional
    public void saveTag(Tag tag){
        repository.saveAndFlush(tag);
    }

    @Transactional
    public void updateTag(Tag tag){
        Optional<Tag> examenTag = repository.findById(tag.getId());
        Tag tempTag = examenTag.get();
        tag.setId(tempTag.getId());
        repository.saveAndFlush(tag);
    }

    @Transactional
    public Tag findById(long id){
        return repository.findById(id).get();
    }

    @Transactional(readOnly = true)
    public List<Tag> findAllTags(){
        return repository.findAll();
    }

}
