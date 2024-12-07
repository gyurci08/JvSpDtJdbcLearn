package hu.pte.mik.probazh.bean;

import hu.pte.mik.probazh.entity.Author;

import java.util.List;

public record BookDTO(
        Long id,
        String title,
        String isbn,

        List<AuthorDTO> authors
) {

}
