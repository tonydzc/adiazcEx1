package com.examen.examen.web;

import com.examen.examen.domain.Tag;
import com.examen.examen.service.TagService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tag")
public class TagController {

    private final TagService service;

    public TagController (TagService service) {
        this.service = service;
    }

    @PostMapping("/register-tag/Tag")
    public ResponseEntity<String> registerTag(@RequestBody Tag tag){
        service.saveTag(tag);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/update-tag")
    public ResponseEntity<String> updateTag(@RequestBody Tag tag){
        service.updateTag(tag);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/find-all")
    public List<Tag> findAllTags(){
        return service.findAllTags();
    }

}
