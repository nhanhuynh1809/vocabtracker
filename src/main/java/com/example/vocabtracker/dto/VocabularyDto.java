package com.example.vocabtracker.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import static lombok.AccessLevel.PRIVATE;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class VocabularyDto {
    Long id;
    @NotBlank(message = "Word is not blank!")
    String word;
    @NotBlank(message = "Meaning is not blank!")
    String meaning;
    String example;
    String level;
    LocalDate learnedDay;
}
