package hu.pte.mik.probazh.database;

import hu.pte.mik.probazh.entity.BookAuthor;
import org.springframework.data.repository.ListCrudRepository;

public interface BookAuthorRepository extends ListCrudRepository<BookAuthor, Long> {

//    @Query("""
//        SELECT COUNT(*) > 0 FROM book_author WHERE book_id = :bookId AND author_id = :authorId
//    """)
//    boolean isBookAuthorExists(Long bookId, Long authorId);
//
//    @Modifying
//    @Query("INSERT INTO book_author (book_id, author_id) VALUES (:bookId, :authorId)")
//    void insertBookAuthorRelation(Long bookId, Long authorId);
//
//    @Modifying
//    @Query("DELETE FROM book_author WHERE book_id = :bookId AND author_id = :authorId")
//    void deleteBookAuthorRelation(Long bookId, Long authorId);

}
