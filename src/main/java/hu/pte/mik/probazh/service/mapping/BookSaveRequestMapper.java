package hu.pte.mik.probazh.service.mapping;

import hu.pte.mik.probazh.bean.BookSaveDTO;
import hu.pte.mik.probazh.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MappingConfig.class, uses = {AuthorMapper.class})
public interface BookSaveRequestMapper extends EntityMapper<Book, BookSaveDTO>{

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authors", source = "authorIds")
    @Override
    Book toEntity(BookSaveDTO dto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "authors", source = "authorIds")
    void mapToTarget(@MappingTarget Book target, BookSaveDTO source);

}
