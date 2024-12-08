package hu.pte.mik.probazh.controller;

import hu.pte.mik.probazh.bean.BookDTO;
import hu.pte.mik.probazh.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<BookDTO> listAllBooks(){
        return bookService.listAllBooks();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Books", description = "Get all Books")
    public BookDTO loadBook(@PathVariable Long id){
        return bookService.loadBook(id);
    }





//    public BookDTO create(BookSaveDTO dto)
//    public BookDTO edit(Long id, BookSaveDTO dto)
//    public void delete(Long id)


}