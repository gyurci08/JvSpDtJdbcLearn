package hu.pte.mik.probazh.entity;

import lombok.Data;

@Data
//@Table("book_author")
public class BookAuthor {
    private Long bookId;
    private Long authorId;
}