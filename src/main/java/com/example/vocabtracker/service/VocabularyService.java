package com.example.vocabtracker.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.vocabtracker.dto.VocabularyDto;
import com.example.vocabtracker.entity.Vocabulary;
import com.example.vocabtracker.exception.GlobalExceptionHandler;
import com.example.vocabtracker.mapper.VocabularyMapper;
import com.example.vocabtracker.repository.VocabularyRepository;

import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.PRIVATE;

@Service
@FieldDefaults(level = PRIVATE)
public class VocabularyService {
    @Autowired
    VocabularyRepository vocabularyRepository;
    @Autowired
    VocabularyMapper vocabularyMapper;

    public List<VocabularyDto> getAllVocab() {
        return vocabularyRepository.findAll().stream()
                .map(vocabularyMapper::toVocabularyDto).toList();

    }

    public VocabularyDto addNewVocab(VocabularyDto vocabularyDto) {
        Vocabulary vocabulary = vocabularyRepository.save(vocabularyMapper.toVocabulary(vocabularyDto));
        return vocabularyMapper.toVocabularyDto(vocabulary);
    }

    public void removeVocab(Long id) {
        vocabularyRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Vocab not found!"));

        vocabularyRepository.deleteById(id);
    }

    public VocabularyDto updateVocab(Long id, VocabularyDto vocabularyDto) {
        return vocabularyRepository.findById(id)
                .map(existing -> {
                    existing.setWord(vocabularyDto.getWord());
                    existing.setMeaning(vocabularyDto.getMeaning());
                    existing.setLearnedDay(LocalDate.now());
                    existing.setExample(vocabularyDto.getExample());
                    existing.setLevel(vocabularyDto.getLevel());
                    return vocabularyMapper.toVocabularyDto(vocabularyRepository.save(existing));
                })
                .orElseThrow(() -> new ResourceNotFoundException("Vocabulary not found with id: " + id));
    }
}