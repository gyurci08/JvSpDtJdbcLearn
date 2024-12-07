package hu.pte.mik.probazh.controller;

import hu.pte.mik.probazh.bean.BookDTO;
import hu.pte.mik.probazh.bean.BookSaveDTO;
import hu.pte.mik.probazh.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/book", produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponse(responseCode = "200", description = "Successful request")
@ApiResponse(responseCode = "500", description = "Internal server error")
@AllArgsConstructor
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
    public BookDTO saveBook(@RequestBody BookSaveDTO bookSaveDTO) {
        return bookService.saveBook(bookSaveDTO);
    }




}