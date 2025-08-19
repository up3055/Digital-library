package com.example.Digital.library.Controller;

import com.example.Digital.library.Adapter.BookAdapter;
import com.example.Digital.library.Entity.Input.InputEntity;
import com.example.Digital.library.Model.BookModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/book")
public class BookController {

    private final BookAdapter bookAdapter;
    @Autowired
    public BookController(BookAdapter bookAdapter){
        this.bookAdapter=bookAdapter;
    }

 @PostMapping("/add")
   public ResponseEntity<?> addBook(@RequestBody InputEntity book){
        return new ResponseEntity<>(
                this.bookAdapter.save(book), HttpStatus.CREATED);
   }

//    @PostMapping("/test")
//    public String test() {
//        return "Working";
//    }
   @PutMapping("/{id}")
    public ResponseEntity<?> updateBook(@PathVariable long id , @RequestBody  InputEntity updatedInput ){

        return new ResponseEntity<>( this.bookAdapter.updateBook(id,updatedInput), HttpStatus.OK);

    }

    @GetMapping("/AllBook")
    public ResponseEntity<?> findAllBook(){
        return new ResponseEntity<>( this.bookAdapter.findAllBook(),HttpStatus.OK);
    }

    @DeleteMapping("/{name}")
    public ResponseEntity<String> deleteBook( @PathVariable String name){
        try {
            bookAdapter.deleteBook(name);
            return ResponseEntity.ok("Book Deleted Successfully");
        } catch (NoSuchElementException e){
            return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
