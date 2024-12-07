package hu.pte.mik.probazh.database;

import hu.pte.mik.probazh.entity.Book;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends ListCrudRepository<Book, Long> {

    @Query("""
        SELECT b.* FROM book b
        JOIN book_author ba ON b.id = ba.book_id
        WHERE ba.author_id = :authorId
    """)
    List<Book> findBooksByAuthorId(Long authorId);

}
