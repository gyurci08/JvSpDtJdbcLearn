package hu.pte.mik.probazh.controller;

import hu.pte.mik.probazh.service.BookService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/book", produces = MediaType.APPLICATION_JSON_VALUE)
@ApiResponse(responseCode = "200", description = "Successful request")
@ApiResponse(responseCode = "500", description = "Internal server error")
@AllArgsConstructor
public class BookController {
    private final BookService BookService;

//    public List<BookDTO> listAllBooks()		GET
//    public BookDTO loadBook(Long id)	/[ID]	GET
//    public BookDTO create(BookSaveDTO dto)		POST
//    public BookDTO edit(Long id, BookSaveDTO dto)	/[ID]	PUT
//    public void delete(Long id)	/[ID]	DELETE


}