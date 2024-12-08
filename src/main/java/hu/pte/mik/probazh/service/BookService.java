package hu.pte.mik.probazh.service;

import hu.pte.mik.probazh.bean.BookDTO;
import hu.pte.mik.probazh.bean.BookSaveDTO;
import hu.pte.mik.probazh.database.AuthorRepository;
import hu.pte.mik.probazh.database.BookRepository;
import hu.pte.mik.probazh.service.mapping.BookMapper;
import hu.pte.mik.probazh.service.mapping.BookSaveRequestMapper;
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

    public List<BookDTO> listAllBooks(){
        return bookMapper.toDto(bookRepository.findAll());
    }

    public BookDTO loadBook(Long id){
        return bookMapper.toDto(bookRepository.findById(id).orElse(null));
    }

    //TODO: Find what is the root cause of null response for name
    public BookDTO create(BookSaveDTO dto){
        Long id = bookRepository.saveAndFlush(bookSaveRequestMapper.toEntity(dto)).getId();
        return loadBook(id);
    }

}