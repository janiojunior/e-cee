package br.gov.to.cee.ecee.infrastructure.tipodocumento.repository;

import java.util.List;
import java.util.stream.Collectors;

import br.gov.to.cee.ecee.application.tipodocumento.mapper.TipoDocumentoEntityMapper;
import br.gov.to.cee.ecee.domain.tipodocumento.model.TipoDocumento;
import br.gov.to.cee.ecee.domain.tipodocumento.repository.TipoDocumentoRepository;
import br.gov.to.cee.ecee.infrastructure.tipodocumento.entity.TipoDocumentoEntity;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@ApplicationScoped
public class TipoDocumentoRepositoryImpl implements TipoDocumentoRepository {

    @PersistenceContext
    private EntityManager em;

    @Inject
    private TipoDocumentoEntityMapper mapper;

    @Override
    public List<TipoDocumento> findAll() {
        List<TipoDocumentoEntity> entities = em
                .createQuery("SELECT t FROM TipoDocumento t", TipoDocumentoEntity.class).getResultList();
        return entities.stream().map(mapper::toModel).collect(Collectors.toList());
    }

    @Override
    public TipoDocumento findById(Long id) {
        TipoDocumentoEntity entity = em.find(TipoDocumentoEntity.class, id);
        return mapper.toModel(entity);
    }

    @Override
    public void save(TipoDocumento tipoDocumento) {
        TipoDocumentoEntity entity = mapper.toEntity(tipoDocumento);
        em.persist(entity);
    }

    @Override
    public void deleteById(Long id) {
        TipoDocumentoEntity entity = em.find(TipoDocumentoEntity.class, id);
        if (entity != null) {
            em.remove(entity);
        }
    }
}
