package com.example.vocabtracker.mapper;

import org.mapstruct.Mapper;

import com.example.vocabtracker.dto.VocabularyDto;
import com.example.vocabtracker.entity.Vocabulary;

@Mapper(componentModel = "spring")
public interface VocabularyMapper {

    VocabularyDto toVocabularyDto(Vocabulary vocabulary);

    Vocabulary toVocabulary(VocabularyDto vocabularyDto);

}
