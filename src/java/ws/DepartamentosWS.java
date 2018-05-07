/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import entidade.Chamados;
import entidade.Departamento;
import entidade.Usuarios;
import java.io.IOException;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
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
@Path("Departamentos")
public class DepartamentosWS {
    
    HelpDeskRN helpdeskRN;

    @Context
    private UriInfo context;
   

    /**
     * Creates a new instance of DepartamentosWS
     */
    public DepartamentosWS() {
        
        helpdeskRN = new HelpDeskRN();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Departamento> getDepartamento() {
        return (helpdeskRN.listarDepartamento());

    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Departamento adicionar(Departamento departamento,
            @Context HttpServletResponse response) {

        helpdeskRN.inserirDepartamento(departamento);

        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            throw new javax.ws.rs.InternalServerErrorException();
        }
        return departamento;
    }
    
    @GET //buscar departamento por ID
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Departamento getDepartamentoPorId(@PathParam("id") Long id) {
        return helpdeskRN.buscarDepartamentoPorId(id);
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Departamento atualizaDepartamento(@PathParam("id") Long id,
            Departamento departamento){
        departamento.setId(id);
        Departamento departamentoAtualizado = helpdeskRN.atualizarDepartamento(departamento);
        return departamentoAtualizado;
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Departamento deletarDepartamento(@PathParam("id") Long id){
        Departamento departamentoDeletado = helpdeskRN.deletarDepartamento(id);
        return departamentoDeletado;
    }
}
