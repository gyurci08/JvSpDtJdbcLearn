package hu.pte.mik.probazh.controller;

import hu.pte.mik.probazh.bean.BookDTO;
import hu.pte.mik.probazh.bean.BookSaveDTO;
import hu.pte.mik.probazh.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/book", produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponse(responseCode = "200", description = "Successful request")
@ApiResponse(responseCode = "500", description = "Internal server error")
public class BookController {
    private final BookService BookService;

    public BookController(BookService BookService) {
        this.BookService = BookService;
    }


    @GetMapping
    @Operation(summary = "All Books", description = "List all Books")
    public List<BookDTO> getAll() {
        return this.BookService.listAllBooks();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Book", description = "Get Book")
    public BookDTO getById(@PathVariable Long id) {
        return this.BookService.getBookById(id);
    }

    @PostMapping
    @Operation(summary = "Save Book", description = "Save Book")
    public BookDTO saveBook(@RequestBody BookSaveDTO bookSaveDTO) {
        return this.BookService.saveBook(bookSaveDTO);
    }
}