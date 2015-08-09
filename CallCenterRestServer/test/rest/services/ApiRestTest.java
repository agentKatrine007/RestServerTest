package rest.services;

import java.util.Date;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import rest.entities.Inquiry;
import rest.entities.Topic;

public class ApiRestTest {
    
    public ApiRestTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTopics method, of class ApiRest.
     */
    @org.junit.Test
    public void testGetTopics() {
        
        System.out.println("getTopics");
        ApiRest instance = new ApiRest();
        List<Topic> result = instance.getTopics();
        assertNotNull(result);
    }

    /**
     * Test of getCustomersByName method, of class ApiRest.
     */
    @org.junit.Test
    public void testGetCustomersByName() {
        
        System.out.println("getCustomersByName");
        String name = "";
        ApiRest instance = new ApiRest();
        List<Inquiry> result = instance.getCustomersByName(name);
        assertNotNull(result);
    }

    /**
     * Test of getCustomersByNameAndDId method, of class ApiRest.
     */
    @org.junit.Test
    public void testGetCustomersByNameAndDId() {
        
        System.out.println("getCustomersByNameAndDId");
        String name = "";
        Integer inquiryId = null;
        ApiRest instance = new ApiRest();
        List<Inquiry> result = instance.getCustomersByNameAndDId(name, inquiryId);
        assertNotNull(result);
    }

    /**
     * Test of createCustomerInquiries method, of class ApiRest.
     */
    @org.junit.Test
    public void testCreateCustomerInquiries() {
        
        System.out.println("createCustomerInquiries");
        Inquiry entity = new Inquiry();
        entity.setCreateDate(new Date());
        entity.setCustomerName("Test name");
        entity.setDescription("Test description");
        ApiRest instance = new ApiRest();
        assertTrue(instance.createCustomerInquiries(entity));
    }

    /**
     * Test of editCustomerInquiries method, of class ApiRest.
     */
    @org.junit.Test
    public void testEditCustomerInquiries() {
        
        System.out.println("editCustomerInquiries");
        Inquiry entity = new Inquiry();;
        entity.setCustomerName("Test name Updated");
        entity.setDescription("Test description Updated");
        ApiRest instance = new ApiRest();
        assertTrue(instance.editCustomerInquiries("Test name", 1, entity));
    }

    /**
     * Test of removeCustomerInquiries method, of class ApiRest.
     */
    @org.junit.Test
    public void testRemoveCustomerInquiries() {
        
        System.out.println("removeCustomerInquiries");
        ApiRest instance = new ApiRest();
        assertTrue(instance.removeCustomerInquiries("Test name Updated", 1));
    }
    
}
