package hu.pte.mik.probazh.service;


import hu.pte.mik.probazh.bean.BookDTO;
import hu.pte.mik.probazh.database.AuthorRepository;
import hu.pte.mik.probazh.database.BookRepository;
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


    public List<BookDTO> getBooksWithAuthors() {
        return bookMapper.toDTOs(bookRepository.findAll().stream()
                .map(book->{
                    var authors = authorRepository.findAuthorsByBookId(book.getId());
                    book.setAuthors(authors);
                    return book;
                }).collect(Collectors.toList()));
    }


}
