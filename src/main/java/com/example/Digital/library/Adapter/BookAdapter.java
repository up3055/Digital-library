package com.example.Digital.library.Adapter;

import com.example.Digital.library.Entity.Input.InputEntity;
import com.example.Digital.library.Mapper.input.BookInputMapper;
import com.example.Digital.library.Model.BookModel;
import com.example.Digital.library.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.print.Book;
import java.util.List;

@Component
public class BookAdapter  {

    private final BookInputMapper bookInputMapper;

    private final BookService bookService;

//    private  final InputEntity inputEntity;
    @Autowired
    public BookAdapter(BookService bookService , BookInputMapper bookInputMapper){

        this.bookInputMapper = bookInputMapper;
        this.bookService = bookService;
//        this.InputEntity = inputEntity;
    }

    public BookModel save(InputEntity InputEntity){
        return this.bookService.save(this.bookInputMapper.mapToModel(InputEntity));
    }

    public BookModel updateBook(long id ,InputEntity inputEntity){
        return this.bookService.updateBook(id ,this.bookInputMapper.mapToModel(inputEntity));
    }

    public List<String> findAllBook(){
       return this.bookService.findAllBook();
    }

    public void deleteBook(String name){
        bookService.deleteBook(name);
    }
}
