/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidad.service;

import entidad.Pago;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
@Path("entidad.pago")
public class PagoFacadeREST extends AbstractFacade<Pago> {

    @PersistenceContext(unitName = "ServicioWebDeudasGlassFishPU")
    private EntityManager em;

    public PagoFacadeREST() {
        super(Pago.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_JSON})
    public void create(Pago entity) {
        super.create(entity);
    }
    
//    @POST
//    @Consumes({MediaType.APPLICATION_JSON})
//    public void crear(Pago entity) {
//        em.createNativeQuery("INSERT INTO pago(iddeuda,monto,moneda,tipopago,lugarpago) VALUES(?,?,?,?,?)")
//                .setParameter(1, entity.getIddeuda())
//                .setParameter(2, entity.getMonto())
//                .setParameter(3, entity.getMoneda())
//                .setParameter(4, entity.getTipopago())
//                .setParameter(5, entity.getLugarpago())
//                .executeUpdate();
//    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Long id, Pago entity) {
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
//    public Pago find(@PathParam("id") Long id) {
//        return super.find(id);
//    }
    
    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Pago> find(@PathParam("id") Long id) {
        return em.createNamedQuery("Pago.findByIdCliente")
                .setParameter("idcliente", id)
                .getResultList();
    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_JSON})
    public List<Pago> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Pago> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
