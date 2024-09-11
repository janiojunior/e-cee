package br.gov.to.cee.ecee.application.tipodocumento.usecase;

import br.gov.to.cee.ecee.domain.tipodocumento.model.TipoDocumento;
import br.gov.to.cee.ecee.domain.tipodocumento.repository.TipoDocumentoRepository;
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
