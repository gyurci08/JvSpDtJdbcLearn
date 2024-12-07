package hu.pte.mik.probazh.service.mapping;

import hu.pte.mik.probazh.bean.AuthorDTO;
import hu.pte.mik.probazh.bean.BookDTO;
import hu.pte.mik.probazh.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(config = MappingConfig.class, uses = {AuthorMapper.class})
public interface BookMapper {

    @Mapping(target = "authors", source = "authors")
    BookDTO toDTO(Book book, List<AuthorDTO> authors);

}
