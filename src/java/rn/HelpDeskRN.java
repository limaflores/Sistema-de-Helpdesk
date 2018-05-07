/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rn;


import entidade.Chamados;
import entidade.Departamento;
import entidade.Status;
import entidade.Usuarios;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import util.JPAUtil;

/**
 *
 * @author t. Andreta, Felipe_Flores
 */
public class HelpDeskRN {
    
    public HelpDeskRN() {
    }
    //chamados
    public Chamados inserirChamado(Chamados chamados) {
        
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        manager.persist(chamados);
        manager.getTransaction().commit();

        manager.close();

        return (chamados);

    }
    
    public Chamados buscarChamadoPorId(Long id) {
        EntityManager manager = JPAUtil.createManager();
        Chamados chamados = manager.find(Chamados.class, id);
        //Verificacao de id
        manager.close();
        return chamados;
    }

    public Chamados atualizarChamado(Chamados chamados) {
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        chamados = manager.merge(chamados);
        manager.getTransaction().commit();

        manager.close();

        return (chamados);
    }

    public Chamados deletarChamado(Long id) {

        EntityManager manager = JPAUtil.createManager();
        Chamados chamados = manager.find(Chamados.class, id);

        manager.getTransaction().begin();
        manager.remove(chamados);
        manager.getTransaction().commit();

        manager.close();

        return (chamados);

    }

    public List<Chamados> listarChamado() {
        EntityManager manager = JPAUtil.createManager();
        
        Query query = manager.createQuery("select m from Chamados m");
        List<Chamados> listaChamados = query.getResultList();
        manager.close();
        return listaChamados;
    }
    
    //-------------------------------------------------------------------------------------
    
    //Usuarios
    public Usuarios inserirUsuario(Usuarios usuarios) {
        
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        manager.persist(usuarios);
        manager.getTransaction().commit();
        manager.close();

        return (usuarios);

    }
    
    public Usuarios buscarUsuarioPorId(Long id) {
        EntityManager manager = JPAUtil.createManager();
        Usuarios usuarios = manager.find(Usuarios.class, id);
        manager.close();
        return usuarios;
    }

    public Usuarios atualizarUsuario(Usuarios usuarios) {
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        usuarios = manager.merge(usuarios);
        manager.getTransaction().commit();

        manager.close();

        return (usuarios);
    }

    public Usuarios deletarUsuario(Long id) {

        EntityManager manager = JPAUtil.createManager();
        Usuarios usuarios = manager.find(Usuarios.class, id);

        manager.getTransaction().begin();
        manager.remove(usuarios);
        manager.getTransaction().commit();

        manager.close();

        return (usuarios);

    }

    public List<Usuarios> listarUsuarios() {
        EntityManager manager = JPAUtil.createManager();
        
        Query query = manager.createQuery("select m from Usuarios m");
        List<Usuarios> listaUsuarios = query.getResultList();
        manager.close();
        return listaUsuarios;
    }
    
    //-------------------------------------------------------------------------------------
    
    //Status
    public Status inserirStatus(Status status) {
        
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        manager.persist(status);
        manager.getTransaction().commit();

        manager.close();

        return (status);

    }
    
    public Status buscarStatusPorId(Long id) {
        EntityManager manager = JPAUtil.createManager();
        Status status = manager.find(Status.class, id);
        //Verificacao de id
        manager.close();
        return status;
    }

    public Status atualizarStatus(Status status) {
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        status = manager.merge(status);
        manager.getTransaction().commit();

        manager.close();

        return (status);
    }

    public Status deletarStatus(Long id) {

        EntityManager manager = JPAUtil.createManager();
        Status status = manager.find(Status.class, id);

        manager.getTransaction().begin();
        manager.remove(status);
        manager.getTransaction().commit();

        manager.close();

        return (status);

    }

    public List<Status> listarStatus() {
        EntityManager manager = JPAUtil.createManager();
        
        Query query = manager.createQuery("select m from Status m");
        List<Status> listaStatus = query.getResultList();
        manager.close();
        return listaStatus;
    }
    
    //-------------------------------------------------------------------------------------
    //Departamento
    public Departamento inserirDepartamento(Departamento departamento) {
        
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        manager.persist(departamento);
        manager.getTransaction().commit();

        manager.close();

        return (departamento);

    }
    
    public Departamento buscarDepartamentoPorId(Long id) {
        EntityManager manager = JPAUtil.createManager();
        Departamento departamento = manager.find(Departamento.class, id);
        manager.close();
        return departamento;
    }

    public Departamento atualizarDepartamento(Departamento departamento) {
        EntityManager manager = JPAUtil.createManager();

        manager.getTransaction().begin();
        departamento = manager.merge(departamento);
        manager.getTransaction().commit();

        manager.close();

        return (departamento);
    }

    public Departamento deletarDepartamento(Long id) {

        EntityManager manager = JPAUtil.createManager();
        Departamento departamento = manager.find(Departamento.class, id);

        manager.getTransaction().begin();
        manager.remove(departamento);
        manager.getTransaction().commit();

        manager.close();

        return (departamento);

    }

    public List<Departamento> listarDepartamento() {
        EntityManager manager = JPAUtil.createManager();
        
        Query query = manager.createQuery("select d from Departamento d");
        List<Departamento> listaDepartamento = query.getResultList();
        manager.close();
        return listaDepartamento;
    }
}
