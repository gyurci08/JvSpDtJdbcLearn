package hu.pte.mik.probazh.service;

import hu.pte.mik.probazh.bean.BookDTO;
import hu.pte.mik.probazh.database.AuthorRepository;
import hu.pte.mik.probazh.database.BookRepository;
import hu.pte.mik.probazh.service.mapping.BookMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
//@Transactional
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final BookMapper bookMapper;

    public List<BookDTO> listAllBooks(){

        return bookMapper.toDto(bookRepository.findAll());
    }


    //	public BookDTO loadBook(Long id)
    //	public BookDTO create(BookSaveDTO dto)
    //	public BookDTO edit(Long id, BookSaveDTO dto)
    //	public void delete(Long id)


}