package hu.pte.mik.probazh.database;

import hu.pte.mik.probazh.entity.Book;
import org.springframework.data.jdbc.repository.query.Modifying;
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



    @Query("""
        SELECT COUNT(*) > 0 AS isExist FROM book_author WHERE book_id = :bookId AND author_id = :authorId
    """)
    Boolean isBookAuthorExists(Long bookId, Long authorId);




    @Modifying
    @Query("INSERT INTO book_author (book_id, author_id) VALUES (:bookId, :authorId)")
    void insertBookAuthorRelation(Long bookId, Long authorId);




    @Modifying
    @Query("DELETE FROM book_author WHERE book_id = :bookId AND author_id = :authorId")
    void deleteBookAuthorRelation(Long bookId, Long authorId);

}
