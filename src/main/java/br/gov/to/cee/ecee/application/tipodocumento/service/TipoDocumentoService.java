package br.gov.to.cee.ecee.application.tipodocumento.service;

import java.util.List;

import br.gov.to.cee.ecee.domain.tipodocumento.model.TipoDocumento;

public interface TipoDocumentoService {
    List<TipoDocumento> getAllTipoDocumento();
    TipoDocumento getTipoDocumentoById(Long id);
    void createOrUpdateTipoDocumento(TipoDocumento tipoDocumento);
    void deleteTipoDocumento(Long id);
}
