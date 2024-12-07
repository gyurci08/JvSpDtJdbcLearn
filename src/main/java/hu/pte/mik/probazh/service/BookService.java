package hu.pte.mik.probazh.service;


import hu.pte.mik.probazh.bean.BookDTO;
import hu.pte.mik.probazh.bean.BookSaveDTO;
import hu.pte.mik.probazh.database.AuthorRepository;
import hu.pte.mik.probazh.database.BookRepository;
import hu.pte.mik.probazh.entity.Author;
import hu.pte.mik.probazh.entity.Book;
import hu.pte.mik.probazh.service.mapping.BookMapper;
import hu.pte.mik.probazh.service.mapping.BookSaveRequestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;
    private final BookSaveRequestMapper bookSaveRequestMapper;

    private Book mapAuthorsToBook( Book book) {
        var authors = authorRepository.findAuthorsByBookId(book.getId());
        book.setAuthors(authors);
        return book;
    }

    @Transactional
    protected void modifyBookAuthorRelation(Long bookId, Long authorId) {
        if (bookRepository.isBookAuthorExists(bookId, authorId))
        {
            bookRepository.deleteBookAuthorRelation(bookId, authorId);
        }
        else
        {
            bookRepository.insertBookAuthorRelation(bookId, authorId);
        }
    }








    public List<BookDTO> getBooksWithAuthors() {
        return bookMapper.toDTOs(bookRepository.findAll().stream()
                .map(this::mapAuthorsToBook).collect(Collectors.toList()));
    }


    public BookDTO getBook( Long id) {
        return bookMapper.toDTO(bookRepository.findById(id).map(this::mapAuthorsToBook).orElseThrow(() -> new RuntimeException("Book not found!")));
    }

    @Transactional
    public BookDTO saveBook( BookSaveDTO request) {
        List<Author> authors = request.authorIds().stream()
                .map(authorRepository::findById)
                .flatMap(Optional::stream)
                .toList();

        var book = bookRepository.save(bookSaveRequestMapper.toEntity(request, authors));

        authors.forEach(author ->modifyBookAuthorRelation(book.getId(), author.getId()));

        return bookMapper.toDTO(book);
    }

    // TODO: Should better handle removing author relation
    @Transactional
    public BookDTO editBook(Long id, BookSaveDTO request){
        List<Author> authors = request.authorIds().stream()
                .map(authorRepository::findById)
                .flatMap(Optional::stream)
                .toList();



        var book = bookMapper.toEntity(getBook(id));
        var oldAuthors = book.getAuthors();

        bookSaveRequestMapper.mapToTarget(book, request);
        book = bookRepository.save(book);

        var newAuthors = book.getAuthors();

        List<Author> difference = oldAuthors.stream()
                .filter(element -> !newAuthors.contains(element))
                .toList();

        Book finalBook = book;

        difference.forEach(author -> modifyBookAuthorRelation(finalBook.getId(), author.getId()));

        return bookMapper.toDTO(book);
    }






}
