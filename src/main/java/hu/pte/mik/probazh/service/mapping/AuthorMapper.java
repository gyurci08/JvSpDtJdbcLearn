package hu.pte.mik.probazh.service.mapping;

import hu.pte.mik.probazh.bean.AuthorDTO;
import hu.pte.mik.probazh.entity.Author;
import org.mapstruct.Mapper;

@Mapper(config = MappingConfig.class)
public interface AuthorMapper extends GenericMapper<Author, AuthorDTO> {
}
