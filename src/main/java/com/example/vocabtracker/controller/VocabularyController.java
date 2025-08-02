package com.example.vocabtracker.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.vocabtracker.dto.ApiResponse;
import com.example.vocabtracker.dto.VocabularyDto;
import com.example.vocabtracker.enumfolder.error;
import com.example.vocabtracker.service.VocabularyService;

import jakarta.validation.Valid;
import lombok.experimental.FieldDefaults;

import static lombok.AccessLevel.NONE;
import static lombok.AccessLevel.PRIVATE;

@RestController
@RequestMapping("/api")
@FieldDefaults(level = PRIVATE)
public class VocabularyController {

    @Autowired
    VocabularyService vocabularyService;

    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<VocabularyDto>>> getAllVocabulary() {
        List<VocabularyDto> list = vocabularyService.getAllVocab();
        if (list.size() < 100)
            return ResponseEntity
                    .ok(new ApiResponse<>(error.EMPTY_LIST.getCode(), error.EMPTY_LIST.getMessage(), null));
        return ResponseEntity.ok(new ApiResponse<>(error.SUCCESS.getCode(), error.SUCCESS.getMessage(), list));
    }

    @PostMapping("/add")
    public ResponseEntity<ApiResponse<VocabularyDto>> addNewVocab(@Valid @RequestBody VocabularyDto vocabularyDto) {
        return ResponseEntity.ok(new ApiResponse<>(error.SUCCESS.getCode(), error.SUCCESS.getMessage(),
                vocabularyService.addNewVocab(vocabularyDto)));
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<ApiResponse<?>> removeVocab(@PathVariable Long id) {
        vocabularyService.removeVocab(id);
        return ResponseEntity.ok(new ApiResponse<>(error.SUCCESS.getCode(), error.SUCCESS.getMessage(), ""));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateVocab(@PathVariable Long id, @Valid @RequestBody VocabularyDto vocabularyDto) {
        return ResponseEntity.ok(vocabularyService.updateVocab(id, vocabularyDto));
    }
}
