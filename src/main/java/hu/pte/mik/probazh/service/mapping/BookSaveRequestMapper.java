package hu.pte.mik.probazh.service.mapping;

import hu.pte.mik.probazh.bean.BookDTO;
import hu.pte.mik.probazh.bean.BookSaveDTO;
import hu.pte.mik.probazh.database.AuthorRepository;
import hu.pte.mik.probazh.entity.Author;
import hu.pte.mik.probazh.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(config = MappingConfig.class, uses = {Author.class})
public interface BookSaveRequestMapper extends GenericMapper<Book, BookSaveDTO> {


    @Mapping(target = "authorIds", source = "authors", qualifiedByName = "mapToLong")
    @Override
    BookSaveDTO toDTO(Book entity);

    @Named("mapToLong")
    default List<Long> map(List<Author> value) {
        return value.stream()
                .map(Author::getId)
                .collect(Collectors.toList());
    }

    @Mapping(target = "id", ignore = true) // Will be created by database
    @Mapping(target = "authors", ignore = true) // , source = "authorIds"
    @Override
    Book toEntity(BookSaveDTO dto);


}
