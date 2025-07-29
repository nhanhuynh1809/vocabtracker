package com.example.vocabtracker.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class VocabularyDto {
    Long id;

    String word;
    String meaning;
    String example;
    String level;
    LocalDate learnedDay;
}
