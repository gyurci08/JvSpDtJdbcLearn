package hu.pte.mik.probazh.database;

import hu.pte.mik.probazh.entity.BookAuthor;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface BookAuthorRepository extends ListCrudRepository<BookAuthor, Long> {

    List<BookAuthor> findAllByBookId(Long id);
}
