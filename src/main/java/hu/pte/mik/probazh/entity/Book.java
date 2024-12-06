package hu.pte.mik.probazh.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;

import java.util.Set;

@Data
public class Book {
    @Id
    private Long id;
    private String title;
    private String isbn;

    //private List<Author> authors;
    @MappedCollection(idColumn = "book_id", keyColumn = "author_id")
    private Set<BookAuthor> authors;
}
