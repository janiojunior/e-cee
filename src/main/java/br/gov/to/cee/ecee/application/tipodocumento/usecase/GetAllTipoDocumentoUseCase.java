package br.gov.to.cee.ecee.application.tipodocumento.usecase;

import java.util.List;

import br.gov.to.cee.ecee.domain.tipodocumento.model.TipoDocumento;
import br.gov.to.cee.ecee.domain.tipodocumento.repository.TipoDocumentoRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

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
