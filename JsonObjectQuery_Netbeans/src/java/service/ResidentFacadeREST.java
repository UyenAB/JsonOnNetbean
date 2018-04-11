/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import SmartER.Resident;
import java.sql.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
@Path("smarter.resident")
public class ResidentFacadeREST extends AbstractFacade<Resident> {

    @PersistenceContext(unitName = "SmartERPU")
    private EntityManager em;

    public ResidentFacadeREST() {
        super(Resident.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Resident entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Resident entity) {
        super.edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        super.remove(super.find(id));
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Resident find(@PathParam("id") Integer id) {
        return super.find(id);
    }
  
    
    
//3a. Write Get Method to query table
  
    //Get firstname 
    @GET
@Path("findByFirstname/{firstname}")
 @Produces({"application/json"})
 public List<Resident> findByFirstname(@PathParam("firstname") String
firstname) {
 Query query = em.createNamedQuery("Resident.findByFirstname");
 query.setParameter("firstname", firstname);
 return query.getResultList();
 
 }
    // Get upper firstname
   @GET
@Path("findByUpperFirstname/{firstname}")
 @Produces({"application/json"})
 public List<Resident> findByUpperFirstname(@PathParam("firstname") String
firstname) {
 Query query = em.createNamedQuery("Resident.findByUpperFirstname");
 query.setParameter("firstname", firstname);
 return query.getResultList();
 
 }
 
  //GET surname 
  @GET
@Path("findBySurname/{surname}")
 @Produces({"application/json"})
 public List<Resident> findBySurname(@PathParam("surname") String
surname) {
 Query query = em.createNamedQuery("Resident.findBySurname");
 query.setParameter("surname", surname);
 return query.getResultList();
 
 }
//GET upper surname 
 @GET
@Path("findByUpperSurname/{surname}")
 @Produces({"application/json"})
 public List<Resident> findByUpperSurname(@PathParam("surname") String
surname) {
 Query query = em.createNamedQuery("Resident.findByUpperSurname");
 query.setParameter("surname", surname);
 return query.getResultList();
 
 }

  //Get DOB findByDob
@GET
@Path("findByDob/{dob}")
 @Produces({"application/json"})
 public List<Resident> findByDob(@PathParam("dob") Date
dob) {
 Query query = em.createNamedQuery("Resident.findByDob");
 query.setParameter("dob", dob);
 return query.getResultList();
 
 }
 
 // Get address findByAddress
@GET
@Path("findByAddress/{address}")
 @Produces({"application/json"})
 public List<Resident> findByAddress(@PathParam("address") String
address) {
 Query query = em.createNamedQuery("Resident.findByAddress");
 query.setParameter("address", address);
 return query.getResultList();
 
 }
 
 //Get Postcode findByPostcode
 
@GET
@Path("findByPostcode/{postcode}")
 @Produces({"application/json"})
 public List<Resident> findByPostcode(@PathParam("postcode") String
postcode) {
 Query query = em.createNamedQuery("Resident.findByPostcode");
 query.setParameter("postcode", postcode);
 return query.getResultList();
 
 }
 
 //Get email findByEmail
@GET
@Path("findByEmail/{email}")
 @Produces({"application/json"})
 public List<Resident> findByEmail(@PathParam("email") String
email) {
 Query query = em.createNamedQuery("Resident.findByEmail");
 query.setParameter("email", email);
 return query.getResultList();
 
 }
 //Getphone findByMobile
@GET
@Path("findByMobile/{mobile}")
 @Produces({"application/json"})
 public List<Resident> findByMobile(@PathParam("mobile") String
mobile) {
 Query query = em.createNamedQuery("Resident.findByMobile");
 query.setParameter("mobile", mobile);
 return query.getResultList();
 
 }
 
 //Get number of resident findByNumberofresident
@GET
@Path("findByNumberofresident/{numberofresident}")
 @Produces({"application/json"})
 public List<Resident> findByNumberofresident(@PathParam("numberofresident") Integer
numberofresident) {
 Query query = em.createNamedQuery("Resident.findByNumberofresident");
 query.setParameter("numberofresident", numberofresident);
 return query.getResultList();
 
 }
 //Get energy provider findByEnergyprovider
@GET
@Path("findByEnergyprovider/{energyprovider}")
 @Produces({"application/json"})
 public List<Resident> findByEnergyprovider(@PathParam("energyprovider") String
energyprovider) {
 Query query = em.createNamedQuery("Resident.findByEnergyprovider");
 query.setParameter("energyprovider", energyprovider);
 return query.getResultList();
 
 }
 
// 3b: Dynamic query findResidentBySurnameAndEmail 
 @GET
 @Path("findResidentBySurnameAndEmail/{surname} / {email}")
 @Produces({"application/json"})
 public List<Resident> findResidentBySurnameAndEmail(@PathParam("surname") String surname, @PathParam("email") String email) {
 TypedQuery<Resident> q = em.createQuery("SELECT r FROM Resident r WHERE r.surname = :surname AND r.email = :email", Resident.class);
 q.setParameter("surname", surname);
 q.setParameter("email", email);
 return q.getResultList();
 } 
 
 
 
    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Resident> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Resident> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
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
