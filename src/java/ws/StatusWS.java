/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import entidade.Chamados;
import entidade.Status;
import java.io.IOException;
import java.util.List;
import javax.persistence.OneToMany;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import rn.HelpDeskRN;

/**
 * REST Web Service
 *
 * @author Thiago_Andreta, Felipe_Flores
 */
@Path("Status")
public class StatusWS {

    HelpDeskRN helpdeskRN;
    
    @Context
    private UriInfo context;

    /**
     * Creates a new instance of StatusWS
     */

    public StatusWS() {
        helpdeskRN = new HelpDeskRN();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Status> getStatus() {
        return (helpdeskRN.listarStatus());

    }
    
    @POST   
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Status adicionar(Status status,
            @Context HttpServletResponse response) {

        helpdeskRN.inserirStatus(status);

        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            throw new javax.ws.rs.InternalServerErrorException();
        }
        return status;
    }
    
    @GET //buscar Status por ID
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Status getStatusPorId(@PathParam("id") Long id) {
        return helpdeskRN.buscarStatusPorId(id);
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Status atualizaStatus(@PathParam("id") Long id,
            Status status){
        status.setId(id);
        Status statusAtualizado = helpdeskRN.atualizarStatus(status);
        return statusAtualizado;
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Status deletarStatusDeletado(@PathParam("id") Long id){
        Status statusDeletado = helpdeskRN.deletarStatus(id);
        return statusDeletado;
    }
}
