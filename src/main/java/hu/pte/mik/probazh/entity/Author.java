package hu.pte.mik.probazh.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;


@Data
@Table("author")
public class Author {
    @Id
    private Long id;
    private String name;
}
