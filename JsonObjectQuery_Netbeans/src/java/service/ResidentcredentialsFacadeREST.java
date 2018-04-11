/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import SmartER.Resident;
import SmartER.Residentcredentials;
import java.sql.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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
 * @author levuanhuyen
 */
@Stateless
@Path("smarter.residentcredentials")
public class ResidentcredentialsFacadeREST extends AbstractFacade<Residentcredentials> {

    @PersistenceContext(unitName = "SmartERPU")
    private EntityManager em;

    public ResidentcredentialsFacadeREST() {
        super(Residentcredentials.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Residentcredentials entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") String id, Residentcredentials entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") String id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Residentcredentials find(@PathParam("id") String id) {
        return super.find(id);
    }

    //Get username findByUsername
@GET
@Path("findByUsername/{username}")
 @Produces({"application/json"})
 public List<Residentcredentials> findByUsername(@PathParam("username") String
username) {
 Query query = em.createNamedQuery("Residentcredentials.findByUsername");
 query.setParameter("username", username);
 return query.getResultList();
 
 }
    
    //Get registration date findByRegistrationdate
@GET
@Path("findByRegistrationdate/{registrationdate}")
@Produces({"application/json"})
 public List<Residentcredentials> findByRegistrationdate(@PathParam("registrationdate") Date
registrationdate) {
 Query query = em.createNamedQuery("Residentcredentials.findByRegistrationdate");
 query.setParameter("registrationdate", registrationdate);
 return query.getResultList();
 
 }
        
    
    
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Residentcredentials> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Residentcredentials> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
