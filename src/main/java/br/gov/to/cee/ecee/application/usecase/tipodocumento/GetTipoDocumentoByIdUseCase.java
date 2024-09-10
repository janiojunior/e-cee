package br.gov.to.cee.ecee.application.usecase.tipodocumento;

import br.gov.to.cee.ecee.domain.model.TipoDocumento;
import br.gov.to.cee.ecee.domain.repository.TipoDocumentoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class GetTipoDocumentoByIdUseCase {
    private final TipoDocumentoRepository repository;

    @Inject
    public GetTipoDocumentoByIdUseCase(TipoDocumentoRepository repository) {
        this.repository = repository;
    }

    public TipoDocumento execute(Long id) {
        return repository.findById(id);
    }
}
