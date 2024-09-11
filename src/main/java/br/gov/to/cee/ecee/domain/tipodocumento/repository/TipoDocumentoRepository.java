package br.gov.to.cee.ecee.domain.tipodocumento.repository;

import java.util.List;

import br.gov.to.cee.ecee.domain.tipodocumento.model.TipoDocumento;

public interface TipoDocumentoRepository {
    List<TipoDocumento> findAll();
    TipoDocumento findById(Long id);
    void save(TipoDocumento tipoDocumento);
    void deleteById(Long id);
}
