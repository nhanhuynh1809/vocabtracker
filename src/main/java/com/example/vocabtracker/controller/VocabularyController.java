package com.example.vocabtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vocabtracker.dto.VocabularyDto;
import com.example.vocabtracker.entity.Vocabulary;
import com.example.vocabtracker.service.VocabularyService;

@RestController
@RequestMapping("/api")
public class VocabularyController {

    @Autowired
    VocabularyService vocabularyService;

    @GetMapping("/all")
    public List<VocabularyDto> getAllVocabulary() {
        return vocabularyService.getAllVocab();
    }

    @PostMapping("/add")
    public void addNewVocab(Vocabulary infor) {
        vocabularyService.addNewVocab(infor);
    }

    @DeleteMapping("/remove/{id}")
    public void removeVocab(@PathVariable Long id) {
        vocabularyService.removeVocab(id);
    }

    @PutMapping("/update/{id}")
    public void updateVocab(@PathVariable Long id, @RequestBody Vocabulary vocabulary) {
        vocabularyService.updateVocab(id, vocabulary);
    }
}
