/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import entidade.Chamados;
import entidade.Departamento;
import entidade.Status;
import entidade.Usuarios;
import java.io.IOException;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Path("Chamados")
public class ChamadosWS {
    
    HelpDeskRN helpdeskRN;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelpDeskWS
     */

    
    public ChamadosWS() {
        
        helpdeskRN = new HelpDeskRN();
    }

    /**
     * Retrieves representation of an instance of ws.ChamadosWS
     * @return an instance of java.lang.String
     */
    @GET //listar chamados
    @Produces(MediaType.APPLICATION_JSON)
    public List<Chamados> getChamados() {
        return (helpdeskRN.listarChamado());

    }

    @POST //inserir chamados
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Chamados adicionar(Chamados chamados,
            @Context HttpServletResponse response) {

        helpdeskRN.inserirChamado(chamados);

        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            throw new javax.ws.rs.InternalServerErrorException();
        }
        return chamados;
    }

    @GET //buscar por ID
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Chamados getChamadosPorId(@PathParam("id") Long id) {
        return helpdeskRN.buscarChamadoPorId(id);
    }

    @PUT //atualizar chamado
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Chamados atualiza(@PathParam("id") Long id,
            Chamados chamados){
        chamados.setId(id);
        Chamados chamadosAtualizado = helpdeskRN.atualizarChamado(chamados);
        return chamadosAtualizado;
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Chamados deletar(@PathParam("id") Long id){
        Chamados chamadosDeletado = helpdeskRN.deletarChamado(id);
        return chamadosDeletado;
    }
  
}
