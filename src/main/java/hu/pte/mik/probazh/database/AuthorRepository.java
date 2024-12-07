package hu.pte.mik.probazh.database;

import hu.pte.mik.probazh.entity.Author;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthorRepository extends ListCrudRepository<Author, Long> {

    @Query("""
        SELECT a.* FROM author a
        JOIN book_author ba ON a.id = ba.author_id
        WHERE ba.book_id = :bookId
    """)
    List<Author> findAuthorsByBookId(Long bookId);

}
