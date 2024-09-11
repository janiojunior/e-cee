package br.gov.to.cee.ecee.application.tipodocumento.mapper;

import br.gov.to.cee.ecee.domain.tipodocumento.model.TipoDocumento;
import br.gov.to.cee.ecee.infrastructure.tipodocumento.dto.TipoDocumentoDTO;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TipoDocumentoMapper {

    public TipoDocumentoDTO toDTO(TipoDocumento model) {
        TipoDocumentoDTO dto = new TipoDocumentoDTO(model.getId(), model.getNome(), model.getDescricao());
        return dto;
    }

    public TipoDocumento toModel(TipoDocumentoDTO dto) {
        return new TipoDocumento(dto.id(), dto.nome(), dto.descricao());
    }
}
