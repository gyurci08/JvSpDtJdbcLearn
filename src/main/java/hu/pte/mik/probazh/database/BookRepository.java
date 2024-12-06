package hu.pte.mik.probazh.database;

import hu.pte.mik.probazh.entity.Book;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends ListCrudRepository<Book, Long> {

    @Query("""
                SELECT b.id, b.title, b.isbn, 
                       a.id AS authorId, a.name AS authorName
                FROM books b
                LEFT JOIN book_author ba ON b.id = ba.book_id
                LEFT JOIN authors a ON ba.author_id = a.id
                WHERE b.id = :id
            """)
    List<Book> findByIdWithAuthors(Long id);

}