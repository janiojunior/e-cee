package br.gov.to.cee.ecee.infrastructure.resource;

import java.util.List;
import java.util.stream.Collectors;

import br.gov.to.cee.ecee.application.mapper.TipoDocumentoMapper;
import br.gov.to.cee.ecee.application.service.TipoDocumentoService;
import br.gov.to.cee.ecee.domain.model.TipoDocumento;
import br.gov.to.cee.ecee.infrastructure.dto.TipoDocumentoDTO;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/tipodocumento")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class TipoDocumentoResource {

    @Inject
    private TipoDocumentoService tipoDocumentoService;

    @Inject
    private TipoDocumentoMapper tipoDocumentoMapper;

    @GET
    public List<TipoDocumentoDTO> getAllTipoDocumento() {
        List<TipoDocumento> tipoDocumento = tipoDocumentoService.getAllTipoDocumento();
        return tipoDocumento.stream()
                .map(tipoDocumentoMapper::toDTO)
                .collect(Collectors.toList());
    }

    @GET
    @Path("/{id}")
    public TipoDocumentoDTO getTipoDocumentoById(@PathParam("id") Long id) {
        TipoDocumento tipoDocumento = tipoDocumentoService.getTipoDocumentoById(id);
        return tipoDocumentoMapper.toDTO(tipoDocumento);
    }

    @POST
    public Response createTipoDocumento(@Valid TipoDocumentoDTO tipoDocumentoDTO) {
        TipoDocumento tipoDocumento = tipoDocumentoMapper.toModel(tipoDocumentoDTO);
        tipoDocumentoService.createOrUpdateTipoDocumento(tipoDocumento);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTipoDocumento(@PathParam("id") Long id, @Valid TipoDocumentoDTO tipoDocumentoDTO) {
        TipoDocumento tipoDocumento = tipoDocumentoMapper.toModel(tipoDocumentoDTO);
        tipoDocumento.setId(id);
        tipoDocumentoService.createOrUpdateTipoDocumento(tipoDocumento);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteTipoDocumento(@PathParam("id") Long id) {
        tipoDocumentoService.deleteTipoDocumento(id);
        return Response.noContent().build();
    }
}
