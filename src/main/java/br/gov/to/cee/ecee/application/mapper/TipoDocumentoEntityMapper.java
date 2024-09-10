package br.gov.to.cee.ecee.application.mapper;

import br.gov.to.cee.ecee.domain.model.TipoDocumento;
import br.gov.to.cee.ecee.infrastructure.entity.TipoDocumentoEntity;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TipoDocumentoEntityMapper {

    public TipoDocumentoEntity toEntity(TipoDocumento model) {
        TipoDocumentoEntity entity = new TipoDocumentoEntity();
        entity.setId(model.getId());
        entity.setNome(model.getNome());
        entity.setDescricao(model.getDescricao());
        return entity;
    }

    public TipoDocumento toModel(TipoDocumentoEntity entity) {
        return new TipoDocumento(entity.getId(), entity.getNome(), entity.getDescricao());
    }
}
