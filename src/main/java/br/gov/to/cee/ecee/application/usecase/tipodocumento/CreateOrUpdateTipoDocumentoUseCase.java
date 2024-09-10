package br.gov.to.cee.ecee.application.usecase.tipodocumento;

import br.gov.to.cee.ecee.domain.model.TipoDocumento;
import br.gov.to.cee.ecee.domain.repository.TipoDocumentoRepository;
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
