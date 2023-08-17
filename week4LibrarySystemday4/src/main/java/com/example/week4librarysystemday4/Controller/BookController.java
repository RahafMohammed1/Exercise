package com.example.week4librarysystemday4.Controller;

import com.example.week4librarysystemday4.ApiResponse.ApiResponse;
import com.example.week4librarysystemday4.Model.Book;
import com.example.week4librarysystemday4.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/book")
public class BookController {
    private final BookService bookService;
    @GetMapping("/getall")
    public ResponseEntity getAll()
    {
        return ResponseEntity.status(200).body(bookService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addBook(@Valid @RequestBody Book book)
    {
        bookService.addBook(book);
        return ResponseEntity.status(200).body(new ApiResponse("the Book is added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBook(@PathVariable Integer id, @Valid @RequestBody Book book)
    {
        bookService.updateBook(id,book);
        return ResponseEntity.status(200).body(new ApiResponse("the Book is updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBook(@PathVariable Integer id)
    {
        bookService.deleteBook(id);
        return ResponseEntity.status(200).body(new ApiResponse("the Book is deleted"));
    }
    @GetMapping("/getbyc/{category}")
    public ResponseEntity GetBooksByCategory(@PathVariable String category)
    {
       return ResponseEntity.status(200).body(bookService.GetBooksByCategory(category));
    }
    @GetMapping("/getbypage")
    public ResponseEntity GetBooksByNumberOfPage()
    {
        return ResponseEntity.status(200).body(bookService.getBookBysNumberOfPage());
    }
    @GetMapping("/getbya/{author}")
    public ResponseEntity GetBooksByAuthor(@PathVariable String author)
    {
        return ResponseEntity.status(200).body(bookService.getBookByAuthor(author));
    }
    @GetMapping("/getbyt/{title}")
    public ResponseEntity GetBooksByTitle(@PathVariable String title)
    {
        return ResponseEntity.status(200).body(bookService.searchByTitle(title));
    }

}
