package com.example.week4librarysystemday4.Controller;

import com.example.week4librarysystemday4.ApiResponse.ApiResponse;
import com.example.week4librarysystemday4.Model.Book;
import com.example.week4librarysystemday4.Model.Librarian;
import com.example.week4librarysystemday4.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/librarian")
public class LibrarianController  {
    private final LibrarianService librarianService;
    @GetMapping("/getall")
    public ResponseEntity getAll()
    {
        return ResponseEntity.status(200).body(librarianService.getAll());
    }
    @PostMapping("/add")
    public ResponseEntity addLibrarian(@Valid @RequestBody Librarian librarian)
    {
       librarianService.addLibrarian(librarian);
        return ResponseEntity.status(200).body(new ApiResponse("the Librarian is added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id, @Valid @RequestBody Librarian librarian)
    {
        librarianService.updateLibrarian(id,librarian);
        return ResponseEntity.status(200).body(new ApiResponse("the Librarian is updated"));
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLibrarian(@PathVariable Integer id)
    {
       librarianService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("the Librarian is deleted"));
    }
    @GetMapping("/getbyid/{id}")
    public ResponseEntity GetLibrarianById(@PathVariable Integer id)
    {
        return ResponseEntity.status(200).body(librarianService.LibrarianById(id));
    }
    @GetMapping("/login/{username}/{password}")
    public ResponseEntity loginCheck(@PathVariable String username ,@PathVariable String password)
    {
        librarianService.checkLogin(username,password);
        return ResponseEntity.status(200).body("the Librarian is login correctly");
    }
    @GetMapping("/getbye/{email}")
    public ResponseEntity getByEmail(@PathVariable String email ){
        return ResponseEntity.status(200).body(librarianService.getByEmail(email));
    }









}
