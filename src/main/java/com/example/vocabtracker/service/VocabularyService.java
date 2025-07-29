package com.example.vocabtracker.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.vocabtracker.dto.VocabularyDto;
import com.example.vocabtracker.entity.Vocabulary;
import com.example.vocabtracker.mapper.VocabularyMapper;
import com.example.vocabtracker.repository.VocabularyRepository;

@Service
public class VocabularyService {
    @Autowired
    VocabularyRepository vocabularyRepository;
    @Autowired
    VocabularyMapper vocabularyMapper;

    public List<VocabularyDto> getAllVocab() {
        List<VocabularyDto> vocabList = vocabularyRepository.findAll().stream()
                .map(vocabularyMapper::toVocabularyDto).toList();
        return vocabList;
    }

    public void addNewVocab(Vocabulary vocabulary) {
        vocabularyRepository.save(vocabulary);
    }

    public void removeVocab(Long id) {
        vocabularyRepository.deleteById(id);
    }

    public Vocabulary updateVocab(Long id, Vocabulary vocabulary) {
        return vocabularyRepository.findById(id)
                .map(existing -> {
                    existing.setWord(vocabulary.getWord());
                    existing.setMeaning(vocabulary.getMeaning());
                    return vocabularyRepository.save(existing);
                })
                .orElse(null);
    }
}