package br.gov.to.cee.ecee.infrastructure.tipodocumento.service;

import java.util.List;

import br.gov.to.cee.ecee.application.tipodocumento.service.TipoDocumentoService;
import br.gov.to.cee.ecee.application.tipodocumento.usecase.CreateOrUpdateTipoDocumentoUseCase;
import br.gov.to.cee.ecee.application.tipodocumento.usecase.DeleteTipoDocumentoUseCase;
import br.gov.to.cee.ecee.application.tipodocumento.usecase.GetAllTipoDocumentoUseCase;
import br.gov.to.cee.ecee.application.tipodocumento.usecase.GetTipoDocumentoByIdUseCase;
import br.gov.to.cee.ecee.domain.tipodocumento.model.TipoDocumento;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TipoDocumentoServiceImpl implements TipoDocumentoService {

    @Inject
    private GetAllTipoDocumentoUseCase getAllTipoDocumentoUseCase;

    @Inject
    private GetTipoDocumentoByIdUseCase getTipoDocumentoByIdUseCase;

    @Inject
    private CreateOrUpdateTipoDocumentoUseCase createOrUpdateTipoDocumentoUseCase;

    @Inject
    private DeleteTipoDocumentoUseCase deleteTipoDocumentoUseCase;

    @Override
    public List<TipoDocumento> getAllTipoDocumento() {
        return getAllTipoDocumentoUseCase.execute();
    }

    @Override
    public TipoDocumento getTipoDocumentoById(Long id) {
        return getTipoDocumentoByIdUseCase.execute(id);
    }

    @Override
    @Transactional
    public void createOrUpdateTipoDocumento(TipoDocumento tipoDocumento) {
        createOrUpdateTipoDocumentoUseCase.execute(tipoDocumento);
    }

    @Override
    @Transactional
    public void deleteTipoDocumento(Long id) {
        deleteTipoDocumentoUseCase.execute(id);
    }
}