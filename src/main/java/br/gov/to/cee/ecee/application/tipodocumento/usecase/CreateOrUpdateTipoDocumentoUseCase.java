package br.gov.to.cee.ecee.application.tipodocumento.usecase;

import br.gov.to.cee.ecee.domain.tipodocumento.model.TipoDocumento;
import br.gov.to.cee.ecee.domain.tipodocumento.repository.TipoDocumentoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CreateOrUpdateTipoDocumentoUseCase {
    private final TipoDocumentoRepository repository;

    @Inject
    public CreateOrUpdateTipoDocumentoUseCase(TipoDocumentoRepository repository) {
        this.repository = repository;
    }

    public void execute(TipoDocumento tipoDocumento) {
        repository.save(tipoDocumento);
    }
}
