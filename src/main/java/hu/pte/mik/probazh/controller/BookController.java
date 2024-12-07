package hu.pte.mik.probazh.controller;

import hu.pte.mik.probazh.bean.BookDTO;
import hu.pte.mik.probazh.bean.BookSaveDTO;
import hu.pte.mik.probazh.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/book", produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponse(responseCode = "200", description = "Successful request")
@ApiResponse(responseCode = "500", description = "Internal server error")
@AllArgsConstructor
@Tag(name = "Book Controller", description = "Managing book API")   // http://localhost:8888/swagger-ui/index.html
public class BookController {
    private final BookService bookService;


    @GetMapping
    @Operation(summary = "All Books", description = "List all Books")
    public List<BookDTO> getAllBooks() {
        return bookService.getBooksWithAuthors();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Book", description = "Get Book")
    public BookDTO getById(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PostMapping
    @Operation(summary = "Save Book", description = "Save Book")
    public BookDTO saveBook(@RequestBody BookSaveDTO request) {
        return bookService.saveBook(request);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Edit Book", description = "Edit Book")
    public BookDTO edit(@PathVariable Long id, @RequestBody BookSaveDTO request){
        return bookService.editBook(id, request);
    }




}