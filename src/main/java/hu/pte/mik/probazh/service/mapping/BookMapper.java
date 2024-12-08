package hu.pte.mik.probazh.service.mapping;

import hu.pte.mik.probazh.bean.BookDTO;
import hu.pte.mik.probazh.entity.Book;
import org.mapstruct.Mapper;

@Mapper(config = MappingConfig.class, uses = {AuthorMapper.class})
public interface BookMapper  extends GenericMapper<Book, BookDTO> {

}
