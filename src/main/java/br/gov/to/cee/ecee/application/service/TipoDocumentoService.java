package br.gov.to.cee.ecee.application.service;

import br.gov.to.cee.ecee.domain.model.TipoDocumento;
import java.util.List;

public interface TipoDocumentoService {
    List<TipoDocumento> getAllTipoDocumento();
    TipoDocumento getTipoDocumentoById(Long id);
    void createOrUpdateTipoDocumento(TipoDocumento tipoDocumento);
    void deleteTipoDocumento(Long id);
}
