package hu.pte.mik.probazh.service.mapping;

import hu.pte.mik.probazh.bean.BookSaveDTO;
import hu.pte.mik.probazh.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = MappingConfig.class, uses = {AuthorMapper.class})
public interface BookSaveRequestMapper extends EntityMapper<Book, BookSaveDTO>{

    @Mapping(target = "id", ignore = true)      // Will be created by database
    @Mapping(target = "authors", ignore = true)
    @Override
    Book toEntity(BookSaveDTO dto);
}
