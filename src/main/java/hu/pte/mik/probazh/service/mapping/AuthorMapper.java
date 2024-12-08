package hu.pte.mik.probazh.service.mapping;

import hu.pte.mik.probazh.bean.AuthorDTO;
import hu.pte.mik.probazh.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(config = MappingConfig.class)
public interface AuthorMapper extends GenericMapper<Author, AuthorDTO> {

    @Mapping(target = "name", ignore = true)
    @Mapping(target = "id", source = "authorId")
    Author toEntity(Long authorId);
}
