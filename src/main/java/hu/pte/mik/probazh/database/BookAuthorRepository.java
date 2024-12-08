package hu.pte.mik.probazh.database;

import hu.pte.mik.probazh.entity.BookAuthor;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface BookAuthorRepository extends ListCrudRepository<BookAuthor, Long> {

    List<BookAuthor> findAllByBookId(Long id);

    @Modifying
    @Query("DELETE FROM book_author WHERE book_id = :bookId")   // Without: "Incorrect result size: expected 1, actual 3"
    void deleteAllByBookId(Long bookId);
}
