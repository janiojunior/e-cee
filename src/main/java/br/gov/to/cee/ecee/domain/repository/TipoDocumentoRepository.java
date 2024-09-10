package br.gov.to.cee.ecee.domain.repository;

import br.gov.to.cee.ecee.domain.model.TipoDocumento;
import java.util.List;

public interface TipoDocumentoRepository {
    List<TipoDocumento> findAll();
    TipoDocumento findById(Long id);
    void save(TipoDocumento tipoDocumento);
    void deleteById(Long id);
}
