package com.example.vocabtracker.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import static lombok.AccessLevel.PRIVATE;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vocabulary")
@FieldDefaults(level = PRIVATE)
public class Vocabulary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String word;
    String meaning;
    String example;
    String level;
    LocalDate learnedDay;
    LocalDate updateDay;

    // tu tao gia tri ban dau khi save tu
    @PrePersist
    protected void onCreate() {
        if (updateDay == null) {
            this.learnedDay = LocalDate.now();
            this.updateDay = LocalDate.now();
        }
    }
}
