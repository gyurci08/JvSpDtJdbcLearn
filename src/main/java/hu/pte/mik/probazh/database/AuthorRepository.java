package hu.pte.mik.probazh.database;

import hu.pte.mik.probazh.entity.Author;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends ListCrudRepository<Author, Long> {

    // Finds all Author record with its id in the list
    List<Author> findAllByIdIn(List<Long> ids);

}