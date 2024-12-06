package hu.pte.mik.probazh.service;

import hu.pte.mik.probazh.bean.AuthorDTO;
import hu.pte.mik.probazh.database.AuthorRepository;
import hu.pte.mik.probazh.service.mapping.AuthorMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthorService {
    private final AuthorRepository authorRepository;
    private final AuthorMapper authorMapper;

    public List<AuthorDTO> listAllAuthors() {
        return authorMapper.toDTOs(authorRepository.findAll());
    }
}