/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad.service;

import entidad.Deuda;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.QueryHint;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Marcelo
 */
@Stateless
@Path("entidad.deuda")
public class DeudaFacadeREST extends AbstractFacade<Deuda> {

    @PersistenceContext(unitName = "ServicioWebDeudasGlassFishPU")
    private EntityManager em;

    public DeudaFacadeREST() {
        super(Deuda.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Deuda entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Deuda entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Long id) {
        super.remove(super.find(id));
    }

//    @GET
//    @Path("{id}")
//    @Produces({MediaType.APPLICATION_JSON})
//    public Deuda find(@PathParam("id") Long id) {
//        return super.find(id);
//    }
    
    @GET
    @Path("deuda/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public Deuda find(@PathParam("id") Long id) {
        return super.find(id);
    }
    
    @GET
    @Path("{idcliente}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Deuda> findDeudas(@PathParam("idcliente") Long idcliente) {
        em.clear();
        return em.createNamedQuery("Deuda.findByIdcliente")
                .setParameter("idcliente", idcliente)
                .getResultList();
//        return em.createNamedQuery("Deuda.findByIddeuda")
//                .setParameter("iddeuda", idcliente)
//                .getResultList();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Deuda> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Deuda> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
