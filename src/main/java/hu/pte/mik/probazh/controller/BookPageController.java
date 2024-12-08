package hu.pte.mik.probazh.controller;

import hu.pte.mik.probazh.entity.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Slf4j
@Controller
public class BookPageController {

    private final RestTemplate restTemplate;

    public BookPageController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/books")
    public String listBooks(Model model) {
        String apiUrl = "http://localhost:8888/api/book";
        try {
            ResponseEntity<List<Book>> response = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.GET,
                    null,
                    new ParameterizedTypeReference<List<Book>>() {}
            );
            List<Book> books = response.getBody();
            model.addAttribute("books", books);
        } catch (Exception e) {
            log.error("Error fetching books from API", e);
            model.addAttribute("error", "Unable to fetch books. Please try again later.");
        }
        return "books";
    }


}
