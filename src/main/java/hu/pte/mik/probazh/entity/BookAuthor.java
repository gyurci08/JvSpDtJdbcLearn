package hu.pte.mik.probazh.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class BookAuthor {
    @Id
    private Long id;
    private Long bookId;
    private Long authorId;
}