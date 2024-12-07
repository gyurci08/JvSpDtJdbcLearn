package hu.pte.mik.probazh.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.util.List;


@Data
public class Book {
    @Id
    private Long id;
    private String title;
    private String isbn;

    @Transient
    private List<Author> authors;
}
