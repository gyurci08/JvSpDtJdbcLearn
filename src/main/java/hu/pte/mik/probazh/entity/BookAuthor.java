package hu.pte.mik.probazh.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@Table("book_author")
public class BookAuthor {
    @Id
    private Long id;
    private Long bookId;
    private Long authorId;
}