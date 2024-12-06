package hu.pte.mik.probazh.database;

import hu.pte.mik.probazh.entity.Author;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends ListCrudRepository<Author, Long> {

}