package hu.pte.mik.probazh.service.mapping;

import hu.pte.mik.probazh.bean.BookDTO;
import hu.pte.mik.probazh.entity.Book;
import org.mapstruct.Mapper;

//, uses = AuthorMapper.class // Could not get it work :/
@Mapper(config = MappingConfig.class)
public interface BookMapper extends GenericMapper<Book, BookDTO> {

}
