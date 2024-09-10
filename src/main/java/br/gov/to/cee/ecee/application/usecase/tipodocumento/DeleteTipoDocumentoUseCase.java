package br.gov.to.cee.ecee.application.usecase.tipodocumento;

import br.gov.to.cee.ecee.domain.repository.TipoDocumentoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class DeleteTipoDocumentoUseCase {
    private final TipoDocumentoRepository repository;

    @Inject
    public DeleteTipoDocumentoUseCase(TipoDocumentoRepository repository) {
        this.repository = repository;
    }

    public void execute(Long id) {
        repository.deleteById(id);
    }
}
