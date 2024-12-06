package hu.pte.mik.probazh.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Author {
    @Id
    private Long id;
    private String name;
}
