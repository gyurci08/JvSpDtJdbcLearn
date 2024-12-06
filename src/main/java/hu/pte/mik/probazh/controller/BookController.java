package hu.pte.mik.probazh.controller;

import hu.pte.mik.probazh.bean.BookDTO;
import hu.pte.mik.probazh.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}