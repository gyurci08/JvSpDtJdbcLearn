package hu.pte.mik.probazh.service.mapping;

import hu.pte.mik.probazh.bean.BookSaveDTO;
import hu.pte.mik.probazh.entity.Book;
import org.mapstruct.Mapper;

@Mapper(config = MappingConfig.class, uses = {AuthorMapper.class})
public interface BookSaveRequestMapper extends EntityMapper<Book, BookSaveDTO>{
}
