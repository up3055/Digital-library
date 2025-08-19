package com.example.Digital.library.Controller;


import com.example.Digital.library.Adapter.BookAdapter;
import com.example.Digital.library.Entity.Input.InputEntity;
import com.example.Digital.library.Model.BookModel;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.Instant;

@ExtendWith(MockitoExtension.class)
public class BookControllerTest {

    // Idea of UT
    // 1. We expect a certain output for a given input
    // 2. Then we run the function that we want to test with given input
    // 3. We check whether the actual output is the same as expected output.
    @Mock
    private BookAdapter bookAdapter;
    @InjectMocks
    private BookController bookController;

    static InputEntity inputEntity;
    static BookModel bookModel;

    @BeforeAll
    static void setUp(){
        inputEntity = InputEntity.builder()
                .id(1L)
                .name("The Farmer")
                .author("AB")
                .description("Motivational story")
                .publishedDate(Instant.now())
                .build();

        bookModel = BookModel.builder()
                .id(1L)
                .author("AB")
                .description("Motivational story")
                .publishedDate(Instant.now())
                .createdAt(Instant.now())
                .updatedAt(null)
                .build();
    }

     @Test
    @DisplayName("Adding New Book - Should Return BookModel")
    void testAddBook(){
         Mockito.when(this.bookAdapter.save(inputEntity)).thenReturn(bookModel);

         ResponseEntity<?> actualResponse = this.bookController.addBook(inputEntity);

         Assertions.assertEquals(HttpStatus.CREATED , actualResponse.getStatusCode());
         Assertions.assertEquals(bookModel,actualResponse.getBody());
         System.out.println("Response Body = " + actualResponse.getBody());
     }

     @Test
    @DisplayName("Updating Book - Should Return BookModel")
    void testUpdateBook(){
        InputEntity modifyEntity = inputEntity.withDescription("Inspirational Story");
        BookModel modifyModel = bookModel.withDescription("Inspirational Story");

        Mockito.when(this.bookAdapter.updateBook(1L , modifyEntity)).thenReturn(modifyModel);

        ResponseEntity<?> actualResponse = this.bookController.updateBook(1l, modifyEntity);


        BookModel responseBody = (BookModel) actualResponse.getBody() ;
        Assertions.assertEquals(HttpStatus.OK , actualResponse.getStatusCode());
        Assertions.assertNotNull(responseBody , "No null");
        Assertions.assertEquals("Inspirational Story" , responseBody.getDescription());
        Assertions.assertEquals(modifyModel , actualResponse.getBody());

        System.out.println("Response Body = " + actualResponse.getBody());

     }

     @Test
    @DisplayName("Deleting Book - should return no Content")
    void testDeleteBook(){
        ResponseEntity<?> actualResponse = this.bookController.deleteBook(inputEntity.getName());

        Assertions.assertEquals(HttpStatus.OK , actualResponse.getStatusCode());
        Assertions.assertEquals("Book Deleted Successfully" , actualResponse.getBody());
         System.out.println("Response Body = " + actualResponse.getBody());
     }

}
