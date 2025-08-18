package com.example.Digital.library.Repository;

import com.example.Digital.library.Entity.Output.OutputEntity;
import com.example.Digital.library.Mapper.output.BookOutputMapper;
import com.example.Digital.library.Model.BookModel;
import com.example.Digital.library.Repository.jpa.BookJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BookRepository {

    private final BookJpaRepository bookJpaRepository;
    private final BookOutputMapper bookOutputMapper;
    @Autowired
    public BookRepository(BookJpaRepository bookJpaRepository , BookOutputMapper bookOutputMapper){
        this.bookJpaRepository=bookJpaRepository;
        this.bookOutputMapper = bookOutputMapper;
    }

    public BookModel save(BookModel bookModel){

        OutputEntity outputEntity = this.bookOutputMapper.mapFromModel(bookModel);

        OutputEntity savedToDB = this.bookJpaRepository.save(outputEntity);

        return this.bookOutputMapper.mapToModel(savedToDB);
    }

    public BookModel findById(long id){
        Optional<OutputEntity> bookOutputEntity = this.bookJpaRepository.findById(id);

        return bookOutputEntity
                .map(this.bookOutputMapper::mapToModel)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
    }

    public BookModel updateBook(long id , BookModel updatedbookModel){
        OutputEntity outputEntity = this.bookJpaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not exist" +id));

        outputEntity.setName(updatedbookModel.getName());
        outputEntity.setAuthor(updatedbookModel.getAuthor());
        outputEntity.setPublishedDate(updatedbookModel.getPublishedDate());

        OutputEntity  saveToDB = this.bookJpaRepository.save(outputEntity);
        return this.bookOutputMapper.mapToModel(saveToDB);
    }

    public List<String> getAllBook(){

        return bookJpaRepository.findAll()
                .stream()
                .map(OutputEntity ::getName)
                .toList();
    }
  @Transactional
    public void deleteBook(String name){

        if(!bookJpaRepository.existsByName(name)){
            throw new EntityNotFoundException("Book with name " + name + "  not Exits");
        }
       bookJpaRepository.deleteByName(name);
    }

  

}
