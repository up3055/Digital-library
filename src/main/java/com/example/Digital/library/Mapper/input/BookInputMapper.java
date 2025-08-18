package com.example.Digital.library.Mapper.input;

import com.example.Digital.library.Entity.Input.InputEntity;
import com.example.Digital.library.Model.BookModel;
import org.springframework.stereotype.Component;
import java.time.Instant;

@Component
public class BookInputMapper {

    public BookModel mapToModel(InputEntity inputEntity){

        return BookModel.builder()
                .name(inputEntity.getName())
                .author(inputEntity.getAuthor())
                .description(inputEntity.getDescription())
                .publishedDate(inputEntity.getPublishedDate())
                .createdAt(Instant.now())
                .build();
    }

}
