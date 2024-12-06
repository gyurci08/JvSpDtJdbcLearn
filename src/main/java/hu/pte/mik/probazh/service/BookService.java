package hu.pte.mik.probazh.service;

import hu.pte.mik.probazh.bean.AuthorDTO;
import hu.pte.mik.probazh.bean.BookDTO;
import hu.pte.mik.probazh.database.AuthorRepository;
import hu.pte.mik.probazh.database.BookRepository;
import hu.pte.mik.probazh.entity.Author;
import hu.pte.mik.probazh.entity.Book;
import hu.pte.mik.probazh.service.mapping.BookMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;


    private List<AuthorDTO> mapAuthors(Book book) {
        return book.getAuthors().stream()
                .map(ba -> {
                    Author author = authorRepository.findById(ba.getAuthorId())
                            .orElseThrow(() -> new RuntimeException("Author not found!"));
                    return new AuthorDTO(author.getId(), author.getName());
                })
                .collect(Collectors.toList());
    }


    public List<BookDTO> listAllBooks() {
        return bookRepository.findAll()
                .stream()
                .map(book -> {
                    List<AuthorDTO> authors = mapAuthors(book);
                    return bookMapper.toDTO(book, authors);
                })
                .collect(Collectors.toList());
    }


    public BookDTO getBookById(Long id) {
        return bookRepository.findById(id)
                .map(book -> {
                    List<AuthorDTO> authors = mapAuthors(book);
                    return bookMapper.toDTO(book, authors);
                })
                .orElseThrow(() -> new RuntimeException("Book not found!"));
    }


}