package hu.pte.mik.probazh.service;

import hu.pte.mik.probazh.bean.BookDTO;
import hu.pte.mik.probazh.bean.BookSaveDTO;
import hu.pte.mik.probazh.database.AuthorRepository;
import hu.pte.mik.probazh.database.BookAuthorRepository;
import hu.pte.mik.probazh.database.BookRepository;
import hu.pte.mik.probazh.entity.Author;
import hu.pte.mik.probazh.entity.Book;
import hu.pte.mik.probazh.entity.BookAuthor;
import hu.pte.mik.probazh.service.mapping.BookMapper;
import hu.pte.mik.probazh.service.mapping.BookSaveRequestMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookAuthorRepository bookAuthorRepository;
    private final BookMapper bookMapper;
    private final BookSaveRequestMapper bookSaveRequestMapper;


    private Book mapAuthorsToBook( Book book ) {
        List<BookAuthor> bookAuthors = bookAuthorRepository.findAllByBookId(book.getId());
        List<Long> authorIds = bookAuthors.stream().map(BookAuthor::getAuthorId).toList();
        List<Author> authors = authorRepository.findAllByIdIn(authorIds);
        book.setAuthors(authors);
        return book;
    }

    private List<BookAuthor> createBookAuthorRelation( BookSaveDTO dto, Book book ) {
        return dto.authorIds().stream()
                .map(authorId ->
                    {
                        BookAuthor bookAuthor = new BookAuthor();
                        bookAuthor.setAuthorId(authorId);
                        bookAuthor.setBookId(book.getId());
                        return bookAuthor;
                    }).toList();
    }



    public List<BookDTO> listAllBooks(){

        return bookMapper.toDto(bookRepository.findAll().stream().map(this::mapAuthorsToBook).toList());
    }


    public BookDTO loadBook(Long id){
        return bookMapper.toDto(bookRepository.findById(id).map(this::mapAuthorsToBook).orElse(null));
    }


    public BookDTO create(BookSaveDTO dto){
        Book book = bookRepository.save(bookSaveRequestMapper.toEntity(dto));
        bookAuthorRepository.saveAll(createBookAuthorRelation(dto, book));

        return loadBook(book.getId());
    }


    // TODO: Diff?
    public BookDTO edit(Long id, BookSaveDTO dto){
        Book book = bookMapper.toEntity(loadBook(id));
        bookSaveRequestMapper.mapToTarget(book, dto);
        book = bookRepository.save(book);
        bookAuthorRepository.deleteAllByBookId(book.getId());
        bookAuthorRepository.saveAll(createBookAuthorRelation(dto, book));

        return loadBook(book.getId());
    }

    	public void delete(Long id){
            Book book = bookMapper.toEntity(loadBook(id));
            bookAuthorRepository.deleteAllByBookId(book.getId());
            bookRepository.delete(book);
        }


}