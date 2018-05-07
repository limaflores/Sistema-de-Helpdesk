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
import javax.persistence.ManyToOne;
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
@Path("Usuarios")
public class UsuariosWS {

    HelpDeskRN helpdeskRN;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UsuariosWS
     */
    public UsuariosWS() {
        helpdeskRN = new HelpDeskRN();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuarios> getUsuario() {
        return (helpdeskRN.listarUsuarios());

    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuarios adicionar(Usuarios usuarios,
            @Context HttpServletResponse response) {

        helpdeskRN.inserirUsuario(usuarios);

        response.setStatus(HttpServletResponse.SC_CREATED);
        try {
            response.flushBuffer();
        } catch (IOException ex) {
            throw new javax.ws.rs.InternalServerErrorException();
        }
        return usuarios;
    }
    
    @GET //buscar Usuarios por ID
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuarios getUsuarioPorId(@PathParam("id") Long id) {
        return helpdeskRN.buscarUsuarioPorId(id);
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuarios atualizaUsuarios(@PathParam("id") Long id,
            Usuarios usuarios){
        usuarios.setId(id);
        Usuarios usuariosAtualizado = helpdeskRN.atualizarUsuario(usuarios);
        return usuariosAtualizado;
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Usuarios deletarusuariosDeletado(@PathParam("id") Long id){
        Usuarios usuariosDeletado = helpdeskRN.deletarUsuario(id);
        return usuariosDeletado;
    }
  
}
