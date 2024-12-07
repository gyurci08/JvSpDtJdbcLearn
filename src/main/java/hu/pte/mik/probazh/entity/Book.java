package hu.pte.mik.probazh.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;

@Data
@Table("book")
public class Book {
    @Id
    private Long id;
    private String title;
    private String isbn;

    @MappedCollection(idColumn = "book_id")
    private List<Author> authors;
}

