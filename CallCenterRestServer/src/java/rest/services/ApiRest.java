package rest.services;

import rest.db.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import rest.entities.Inquiry;
import rest.entities.Topic;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 * REST Web Service
 */
@Path("api")
public class ApiRest {

    @Context
    private UriInfo context;

    public ApiRest() {}

    /**
     * Retrieves all topics.
     * @return a list of Topics
     */
    @GET
    @Path("topics")
    @Produces("application/json")
    public List<Topic> getTopics() {
        
        Session session = null;
        List<Topic> list = new ArrayList<>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            list = session.createCriteria(Topic.class).list();
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }
    
    /**
     * Retrieves all customers inquiry by name.
     * @return a list of customers inquiry
     */
    @GET
    @Path("customers/{name}")
    @Produces("application/json")
    public List<Inquiry> getCustomersByName(@PathParam("name") String name) {
        
        Session session = null;
        List<Inquiry> list = new ArrayList<>();
        try {
            list = session.createCriteria(Inquiry.class).add(Restrictions.eq(Inquiry.FIELD_customerName, name)).list();
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }
    
    /**
     * Retrieves all customers inquiry by name and id.
     * @return a list of customers inquiry
     */
    @GET
    @Path("customers/{name}/inquiry/{inquiryId}")
    @Produces("application/json")
    public List<Inquiry> getCustomersByNameAndDId(@PathParam("name") String name, @PathParam("inquiryId") Integer inquiryId) {
        
        Session session = null;
        List<Inquiry> list = new ArrayList<>();
        try {
            list = session.createCriteria(Inquiry.class).add(Restrictions.eq(Inquiry.FIELD_customerName, name))
                    .add(Restrictions.eq(Inquiry.FIELD_idInquiry, inquiryId)).list();
        } catch (Exception e) {
            return null;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return list;
    }
    
    /**
     * Create new customers inquiry.
     */
    @POST
    @Path("/customers/inquiries")
    @Consumes("application/json")
    public Boolean createCustomerInquiries(Inquiry entity) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
        return true;
    }
    
    /**
     * Update existing customers inquiry.
     */
    @PUT
    @Path("/customers/{customerName}/inquiries/{inquiryId}")
    @Consumes("application/json")
    public Boolean editCustomerInquiries(@PathParam("customerName") String customerName, @PathParam("inquiryId") Integer inquiryId, Inquiry entity) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
        return true;
    }
    
    /**
     * Delete customers inquiry.
     */
    @DELETE
    @Path("/customers/{customerName}/inquiries/{inquiryId}")
    public Boolean removeCustomerInquiries(@PathParam("customerName") String customerName, @PathParam("inquiryId") Integer inquiryId) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            Inquiry inquiry = null;
            inquiry = (Inquiry) session.load(Inquiry.class, inquiryId);
            session.delete(inquiry);
            session.getTransaction().commit();
        } catch (Exception e) {
            return false;
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        
        return true;
    }

}
