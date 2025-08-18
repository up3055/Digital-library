package com.example.Digital.library.Mapper.output;

import com.example.Digital.library.Entity.Output.OutputEntity;
import com.example.Digital.library.Model.BookModel;
import org.springframework.stereotype.Component;

@Component
public class BookOutputMapper {

    public BookModel mapToModel(OutputEntity outputEntity){

        return BookModel.builder().id(outputEntity.getId())
                .name(outputEntity.getName()).author(outputEntity.getAuthor())
                .description(outputEntity.getDescription())
                .createdAt(outputEntity.getCreatedAt())
                .publishedDate(outputEntity.getPublishedDate())
                .updatedAt(outputEntity.getUpdatedAt()).build();



    }
    public OutputEntity mapFromModel(BookModel bookModel){

        return OutputEntity.builder().id(bookModel.getId())
                .name(bookModel.getName())
                .author(bookModel.getAuthor())
                .description(bookModel.getDescription())
                .publishedDate(bookModel.getPublishedDate())
                .updatedAt(bookModel.getUpdatedAt())
                .createdAt(bookModel.getCreatedAt()).build();
    }


}
