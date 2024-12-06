package hu.pte.mik.probazh.service.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import hu.pte.mik.probazh.entity.Book;
import hu.pte.mik.probazh.bean.BookSaveDTO;

@Mapper(config = MappingConfig.class)
public interface BookSaveRequestMapper extends GenericMapper<Book, BookSaveDTO> {

    @Override
    @Mapping(target = "id", ignore = true) // Ignore authors as they are mapped separately
    @Mapping(target = "authors", ignore = true) // Ignore authors as they are mapped separately
    Book toEntity(BookSaveDTO bookSaveDTO);  // Convert BookSaveDTO to Book entity

    @Mapping(target = "authorIds", ignore = true) // Ignore authors as they are mapped separately
    BookSaveDTO toDTO(Book book);
}
