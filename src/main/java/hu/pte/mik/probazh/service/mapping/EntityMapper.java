package hu.pte.mik.probazh.service.mapping;
/**
 * DTO -> entity mapper
 *
 * @param <E>Entity
 * @param <D>DTO
 */
public interface EntityMapper<E, D> {
    E toEntity(D dto);
}
