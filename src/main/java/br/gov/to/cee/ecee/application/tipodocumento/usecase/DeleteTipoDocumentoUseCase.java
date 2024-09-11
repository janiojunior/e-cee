package br.gov.to.cee.ecee.application.tipodocumento.usecase;

import br.gov.to.cee.ecee.domain.tipodocumento.repository.TipoDocumentoRepository;
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
