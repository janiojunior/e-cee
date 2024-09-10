package br.gov.to.cee.ecee.application.usecase.tipodocumento;

import br.gov.to.cee.ecee.domain.model.TipoDocumento;
import br.gov.to.cee.ecee.domain.repository.TipoDocumentoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.util.List;

@ApplicationScoped
public class GetAllTipoDocumentoUseCase {
    private TipoDocumentoRepository repository;

    @Inject
    public GetAllTipoDocumentoUseCase(TipoDocumentoRepository repository) {
        this.repository = repository;
    }

    public List<TipoDocumento> execute() {
        return repository.findAll();
    }
}
