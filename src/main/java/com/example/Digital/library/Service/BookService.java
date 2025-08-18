package com.example.Digital.library.Service;

import com.example.Digital.library.Model.BookModel;
import com.example.Digital.library.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {


    private final BookRepository bookRepository;
    @Autowired
    public BookService(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    public BookModel save(BookModel bookModel){
        return this.bookRepository.save(bookModel);
    }

    public BookModel getBookById(long id){
        return this.bookRepository.findById(id);
    }

    public  BookModel updateBook(long id , BookModel updateBookModel){
        return this.bookRepository.updateBook(id,updateBookModel);
    }
   public List<String>  findAllBook(){
        return this.bookRepository.getAllBook();
   }

   public void deleteBook(String name){
        bookRepository.deleteBook(name);
   }
}
