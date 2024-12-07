package hu.pte.mik.probazh.database;

import hu.pte.mik.probazh.entity.Book;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    @Query("""
           SELECT b.id, b.title, b.isbn, a.id AS author_id, a.name AS author_name
           FROM book b
                    LEFT JOIN book_author ba ON b.id = ba.book_id
                    LEFT JOIN author a ON ba.author_id = a.id
           ORDER BY b.
            id, a.name;
            """)
    List<Book> findAllBooksWithAuthors();
}
