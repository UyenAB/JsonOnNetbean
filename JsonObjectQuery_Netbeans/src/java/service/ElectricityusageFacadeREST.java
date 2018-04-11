/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import SmartER.Electricityusage;
import SmartER.Resident;
import SmartER.highestTotalHourlyPowerConsumption;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;
import javax.ejb.Stateless;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonValue;
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
@Path("smarter.electricityusage")
public class ElectricityusageFacadeREST extends AbstractFacade<Electricityusage> {

    @PersistenceContext(unitName = "SmartERPU")
    private EntityManager em;

    public ElectricityusageFacadeREST() {
        super(Electricityusage.class);
    }

    @POST
    @Override
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void create(Electricityusage entity) {
        super.create(entity);
    }

    @PUT
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void edit(@PathParam("id") Integer id, Electricityusage entity) {
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
    public Electricityusage find(@PathParam("id") Integer id) {
        return super.find(id);
    }
 
    
    // Get date findByDate
    @GET
    @Path("findByDate/{date}")
    @Produces({"application/json"})
    public List<Electricityusage> findByDate(@PathParam("date") Date date) {
        Query query = em.createNamedQuery("Electricityusage.findByDate");
        query.setParameter("date", date);
        return query.getResultList();

    }

    // Get hour findByHourusage
    @GET
    @Path("findByHourusage/{hourusage}")
    @Produces({"application/json"})
    public List<Electricityusage> findByHourusage(@PathParam("hourusage") Integer hourusage) {
        Query query = em.createNamedQuery("Electricityusage.findByHourusage");
        query.setParameter("hourusage", hourusage);
        return query.getResultList();

    }

    // Get findByFridge
    @GET
    @Path("findByFridge/{fridge}")
    @Produces({"application/json"})
    public List<Electricityusage> findByFridge(@PathParam("fridge") Double fridge) {
        Query query = em.createNamedQuery("Electricityusage.findByFridge");
        query.setParameter("fridge", fridge);
        return query.getResultList();

    }

    // Get findByAirconditioner
    @GET
    @Path("findByAirconditioner/{airconditioner}")
    @Produces({"application/json"})
    public List<Electricityusage> findByAirconditioner(@PathParam("airconditioner") Double airconditioner) {
        Query query = em.createNamedQuery("Electricityusage.findByAirconditioner");
        query.setParameter("airconditioner", airconditioner);
        return query.getResultList();

    }
    // Get findByWashingmachine washingmachine 

    @GET
    @Path("findByWashingmachine/{washingmachine}")
    @Produces({"application/json"})
    public List<Electricityusage> findByWashingmachine(@PathParam("washingmachine") Double washingmachine) {
        Query query = em.createNamedQuery("Electricityusage.findByWashingmachine");
        query.setParameter("washingmachine", washingmachine);
        return query.getResultList();

    }
    // Get findByTemperature

    @GET
    @Path("findByTemperature/{temperature}")
    @Produces({"application/json"})
    public List<Electricityusage> findByTemperature(@PathParam("temperature") Double temperature) {
        Query query = em.createNamedQuery("Electricityusage.findByTemperature");
        query.setParameter("temperature", temperature);
        return query.getResultList();

    }

    @GET
    @Override
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Electricityusage> findAll() {
        return super.findAll();
    }

    @GET
    @Path("{from}/{to}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Electricityusage> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return super.findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    @Produces(MediaType.TEXT_PLAIN)
    public String countREST() {
        return String.valueOf(super.count());
    }
    //3c: Dynamic query findResidentByEmailAndHour
 @GET
 @Path("findResidentByEmailAndHour3c/{email} / {hourusage}")
 @Produces({"application/json"})
 public List<Electricityusage> findResidentByEmailAndHour3c(@PathParam("email") String email, @PathParam("hourusage") Integer hourusage) {
 TypedQuery<Electricityusage> q = em.createQuery("SELECT e FROM Electricityusage e WHERE e.resid.email = :email AND e.hourusage = :hourusage", Electricityusage.class);
 
 q.setParameter("email", email);
 q.setParameter("hourusage", hourusage);
 return q.getResultList();
 } 
 
 //3d:Static query findResidentByEmailAndSurname
  @GET
 @Path("findResidentBySurnameAndEmail3d/{surname}/{email}")
 @Produces({"application/json"})
 public List<Electricityusage> findResidentBySurnameAndEmail3d(@PathParam("surname") String surname, @PathParam("email") String email) {
 Query q = em.createNamedQuery("Electricityusage.findResidentBySurnameAndEmail3d");
 q.setParameter("surname", surname);
 q.setParameter("email", email);
 return q.getResultList();
 } 
 
 
    //4a: 
    @GET
    @Path("findHourUsage4a/{resid}/{applianceName}/{date}/{hourusage}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Object findHourUsage4a(@PathParam("resid") Integer resid, @PathParam("applianceName") String applianceName, @PathParam("date") Date date, @PathParam("hourusage") Integer hourusage) {
        TypedQuery<Object[]> query = em.createQuery("Select e.resid.resid, e.date, e.hourusage, e.airconditioner, e.fridge, e.washingmachine  from Electricityusage e where e.resid.resid = :resid and e.date = :date and e.hourusage = :hourusage", Object[].class);
        query.setParameter("resid", resid);
        query.setParameter("date", date);
        query.setParameter("hourusage", hourusage);
        List<Object[]> queryList = query.getResultList();
        //JsonArrayBuilder arrayUsage = Json.createArrayBuilder();
        JsonObject findHourUsage = Json.createObjectBuilder().build();
        double appianceUsage = 0;
        for (Object[] row : queryList) {
            if (applianceName.contains("airconditioner")) {
                appianceUsage = (double) row[3];
            }
            if (applianceName.contains("fridge")) {
                appianceUsage = (double) row[4];
            }
            if (applianceName.contains("washingmachine")) {
                appianceUsage = (double) row[5];
            }
            JsonObject findUsageMachine = Json.createObjectBuilder()
                    .add("resid", (int) row[0])
                    .add("date", row[1].toString())
                    .add("hourusage", (int) row[2])
                    .add("applianceName", applianceName)
                    .add("hourlyPowerUsage", appianceUsage)
                    .build();

            //arrayUsage.add(findUsageMachine);
            findHourUsage = findUsageMachine;

        }

        return findHourUsage;
    }
    //4b:

    @GET
    @Path("findHourUsage4b/{resid}/{date}/{hourusage}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Object findHourUsage4b(@PathParam("resid") Integer resid, @PathParam("date") Date date, @PathParam("hourusage") Integer hourusage) {
        TypedQuery<Object[]> query = em.createQuery("Select e.resid.resid, e.date, e.hourusage, e.airconditioner, e.fridge, e.washingmachine  from Electricityusage e where e.resid.resid = :resid and e.date = :date and e.hourusage = :hourusage", Object[].class);
        query.setParameter("resid", resid);
        query.setParameter("date", date);
        query.setParameter("hourusage", hourusage);
        List<Object[]> queryList = query.getResultList();
        //JsonArrayBuilder arrayUsage = Json.createArrayBuilder();
        JsonObject findHourUsage = Json.createObjectBuilder().build();

        for (Object[] row : queryList) {

            JsonObject findUsageMachine = Json.createObjectBuilder()
                    .add("resid", (int) row[0])
                    .add("date", row[1].toString())
                    .add("hourusage", (int) row[2])
                    .add("airconditioner", (double) row[3])
                    .add("fridge", (double) row[4])
                    .add("washingmachine", (double) row[5])
                    .build();

            //arrayUsage.add(findUsageMachine);
            findHourUsage = findUsageMachine;

        }

        return findHourUsage;
    }

    //4c: return a list the resident id, address, postcode, and the total hourly power usage (for all three appliances)
    @GET
    @Path("findHourUsage4c/{date}/{hourusage}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Object findHourUsage4c(@PathParam("date") Date date, @PathParam("hourusage") Integer hourusage) {
        TypedQuery<Object[]> query = em.createQuery("Select e.usageid,e.resid.resid,e.date,e.hourusage, e.airconditioner, e.fridge, e.washingmachine  from Electricityusage e where e.date = :date and e.hourusage = :hourusage", Object[].class);
        query.setParameter("date", date);
        query.setParameter("hourusage", hourusage);

        List<Object[]> queryList = query.getResultList();
        JsonArrayBuilder arrayUsage = Json.createArrayBuilder();
        for (Object[] row : queryList) {

            Electricityusage electricityusage = find(row[0]);
            String address = electricityusage.getResid().getAddress();
            String postcode = electricityusage.getResid().getPostcode();

            JsonObject findUsageMachine = Json.createObjectBuilder()
                    .add("resid", (int) row[1])
                    .add("postcode", postcode)
                    .add("address", address)
                    .add("totalPowerUsage", ((double) row[4] + (double) row[5] + (double) row[6]))
                    .build();

            arrayUsage.add(findUsageMachine);
        }
        JsonArray jArray = arrayUsage.build();
        return jArray;
    }
//4d
     @GET
    @Path("findHighestHourlyPowerConsump4d/{resid}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
     public highestTotalHourlyPowerConsumption findHighestHourlyPowerConsump4d(@PathParam("resid") Integer resid) {
        TypedQuery<Electricityusage> query = em.createQuery("Select e from Electricityusage e where e.resid.resid = :resid", Electricityusage.class);
        query.setParameter("resid", resid);
        
        List<Electricityusage> queryList = query.getResultList();
        highestTotalHourlyPowerConsumption highestPower = new highestTotalHourlyPowerConsumption();
        Electricityusage finalUsage = new Electricityusage();
        
        
        for(int i =0 ; i<queryList.size();i++)
        {
            if (i < queryList.size() -1 ){
				Electricityusage tempUsage = CompareHouseConsumption(queryList.get(i), queryList.get(i+1));
				if (i==0)
				{
					finalUsage = tempUsage;
					
				}
                finalUsage = CompareHouseConsumption(finalUsage, tempUsage);
			}
        }
        double totalHourlyPowerConsumption = finalUsage.getAirconditioner() + finalUsage.getFridge() + finalUsage.getWashingmachine();
        highestPower.setResid(resid);
        highestPower.setHighestConsump(totalHourlyPowerConsumption);
        highestPower.setDate(finalUsage.getDate().toString());
        highestPower.setHourusage(finalUsage.getHourusage());
        
        
        return highestPower;
    }
     //CompareHouseConsumption
      public Electricityusage CompareHouseConsumption(Electricityusage u1, Electricityusage u2)
    {
        if ((u1.getAirconditioner() + u1.getFridge() + u1.getWashingmachine()) >= (u2.getAirconditioner() + u2.getFridge() + u2.getWashingmachine()))
            {
                return u1;
            }
        else 
        {
            return u2;
        }
    }


     //5a: Response: {{"resid":1, "fridge":7.2,"aircon":0.0,"washingmachine":2.4} 
    @GET
    @Path("findDailyPowerUsagePerAppliances5a/{resid}/{date}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Object findDailyPowerUsagePerAppliances5a(@PathParam("resid") Integer resid, @PathParam("date") Date date) {
        TypedQuery<Object[]> query = em.createQuery("Select e.resid.resid, e.date, e.airconditioner, e.fridge, e.washingmachine  from Electricityusage e where e.resid.resid = :resid and e.date = :date", Object[].class);
        query.setParameter("resid", resid);
        query.setParameter("date", date);

        List<Object[]> queryList = query.getResultList();
        //JsonArrayBuilder arrayUsage = Json.createArrayBuilder();
        JsonObject findHourUsage = Json.createObjectBuilder().build();
        double finalAirConditionUsage = 0;
        double finalFridge = 0;
        double finalWashingMachine = 0;
        for (Object[] row : queryList) {
            double tempAirCondition = (double) row[2];
            finalAirConditionUsage = tempAirCondition + finalAirConditionUsage;
            double tempFridge = (double) row[3];
            finalFridge = tempFridge + finalFridge;
            double tempWasingMachine = (double) row[4];
            finalWashingMachine = tempWasingMachine + finalWashingMachine;

            JsonObject findUsageMachine = Json.createObjectBuilder()
                    .add("resid", (int) row[0])
                    .add("airconditioner", finalAirConditionUsage)
                    .add("fridge", finalFridge)
                    .add("washingmachine", finalWashingMachine)
                    .build();
            //arrayUsage.add(findUsageMachine);
            findHourUsage = findUsageMachine;
        }
        return findHourUsage;
    }
     
     //5b:
   //Hourly: {"resid":1,"usage":0.3,"temperature":34.5,"date":"2018-01-27T00:00:00+11:00", "time":"0"}
    @GET
    @Path("findDailyOrHourlyPowerUsagePerAppliances5b/{resid}/{date}/{usageOpion}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Object findDailyOrHourlyPowerUsagePerAppliances5b(@PathParam("resid") Integer resid, @PathParam("date") Date date, @PathParam("usageOpion") String usageOption) {
        TypedQuery<Object[]> query = em.createQuery("Select e.resid.resid, e.date, e.temperature, e.airconditioner, e.fridge, e.washingmachine, e.hourusage  from Electricityusage e where e.resid.resid = :resid and e.date = :date", Object[].class);
        query.setParameter("resid", resid);
        query.setParameter("date", date);

        List<Object[]> queryList = query.getResultList();
        JsonArrayBuilder arrayUsage = Json.createArrayBuilder();
        JsonObject findHourUsage = Json.createObjectBuilder().build();
        double finalDailyUsage = 0;
        double finalDailyTemp = 0;
        for (Object[] row : queryList) {

            if (usageOption.contains("hourly")) {

                JsonObject listHourlyUsage = Json.createObjectBuilder()
                        .add("resid", (int) row[0])
                        .add("totalUsage", (double) row[3] + (double) row[4] + (double) row[5])
                        .add("temperature", (double) row[2])
                        .add("date", row[1].toString())
                        .add("hour", (int) row[6])
                        .build();

                arrayUsage.add(listHourlyUsage);

            }
            if (usageOption.contains("daily")) {
                double tempDailyUsage = (double) row[3] + (double) row[4] + (double) row[5];
                finalDailyUsage = tempDailyUsage + finalDailyUsage;
                double tempDailyTemperature = (double) row[2];
                finalDailyTemp = tempDailyTemperature + finalDailyTemp;

                JsonObject totalDailyUsage = Json.createObjectBuilder()
                        .add("resid", (int) row[0])
                        .add("usage", (double) finalDailyUsage)
                        .add("temperature", (double) (finalDailyTemp / 24))
                        .build();

                findHourUsage = totalDailyUsage;

            }

        }
        if (usageOption.contains("daily")) {
            return findHourUsage;
        }

        JsonArray arrayBuilder = arrayUsage.build();
        return arrayBuilder;
    }


    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

}
