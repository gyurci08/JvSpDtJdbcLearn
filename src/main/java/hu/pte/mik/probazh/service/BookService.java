package hu.pte.mik.probazh.service;

import hu.pte.mik.probazh.bean.BookDTO;
import hu.pte.mik.probazh.bean.BookSaveDTO;
import hu.pte.mik.probazh.database.AuthorRepository;
import hu.pte.mik.probazh.database.BookRepository;
import hu.pte.mik.probazh.entity.Book;
import hu.pte.mik.probazh.service.mapping.BookMapper;
import hu.pte.mik.probazh.service.mapping.BookSaveRequestMapper;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;
    private final BookSaveRequestMapper bookSaveRequestMapper;


    private Book findBookById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Book ID must not be null");
        }

        return bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Book not found with id: " + id));
    }








    public List<BookDTO> listAllBooks(){
        return bookMapper.toDto(bookRepository.findAll());
    }

    public BookDTO loadBook(Long id){
        return bookMapper.toDto(findBookById(id));
    }

    //TODO: Find what is the root cause of null response for name
    public BookDTO create(BookSaveDTO dto){
       return bookMapper.toDto(bookRepository.save(bookSaveRequestMapper.toEntity(dto)));
    }



    public BookDTO edit(Long id, BookSaveDTO dto){
        Book book = findBookById(id);
        bookSaveRequestMapper.mapToTarget(book,dto);
        return bookMapper.toDto(bookRepository.save(book));
    }


    public void delete(Long id){
        bookRepository.delete(findBookById(id));
    }







}