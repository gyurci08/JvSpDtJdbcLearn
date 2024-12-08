package hu.pte.mik.probazh.service.mapping;

import hu.pte.mik.probazh.bean.BookSaveDTO;
import hu.pte.mik.probazh.entity.Book;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(config = MappingConfig.class, uses = {AuthorMapper.class})
public interface BookSaveRequestMapper extends EntityMapper<Book, BookSaveDTO>{

    @Mapping(target = "id", ignore = true)      // Will be created by database
    @Mapping(target = "authors", ignore = true)
    @Override
    Book toEntity(BookSaveDTO dto);


    @Mapping(target = "authors", ignore = true)
    @Mapping(target = "id", ignore = true)
    void mapToTarget(@MappingTarget Book target, BookSaveDTO source);

}
