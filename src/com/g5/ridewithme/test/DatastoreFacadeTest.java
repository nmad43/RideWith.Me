package com.g5.ridewithme.test;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;

import static com.google.appengine.api.datastore.FetchOptions.Builder.withLimit;

import com.google.appengine.api.datastore.Query;
import com.google.appengine.tools.development.testing.LocalDatastoreServiceTestConfig;
import com.google.appengine.tools.development.testing.LocalServiceTestHelper;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.g5.ridewithme.Customer;
import com.g5.ridewithme.DatastoreFacade;
import com.g5.ridewithme.EMF;

public class DatastoreFacadeTest {
	
    private final LocalServiceTestHelper helper =
            new LocalServiceTestHelper(new LocalDatastoreServiceTestConfig());

    private static void sameCustomer(Customer cust1, Customer cust2)
    {
    	assertEquals("Should have same id", cust1.getId(), cust2.getId());
    	assertEquals("should have same first name", cust1.getFirstName(), cust2.getFirstName());
    	assertEquals("should have same last name", cust1.getLastName(), cust2.getLastName());
    	assertEquals("should have the same email", cust1.getEmail(), cust2.getEmail());
    }
 	
    @Before
    public void setUp() {
        helper.setUp();
        Customer cust1 = new Customer("20", "Foo", "Bar", "foo.bar@example.com", "FIU", "Car");
        EntityManager mgr = getEntityManager();
		try {
			mgr.persist(cust1);
		} finally {
			mgr.close();
		}
    }

    @After
    public void tearDown() {
        helper.tearDown();
        Customer cust1 = new Customer("20", "Foo", "Bar", "foo.bar@example.com", "FIU", "Car");
        EntityManager mgr = getEntityManager();
        try {
        	mgr.remove(cust1);
        } finally {
        	mgr.close();
        }
    }

	
	@Test
	public void testIsNotACustomer() {
		assertFalse("should be false", DatastoreFacade.isACustomer("999"));
	}
	
	@Test
	public void testIsACustomer() {
		assertTrue("should be true", DatastoreFacade.isACustomer("20"));
	}

	@Test
	public void testVerifyCustomer() {
		assertTrue("should be the same user", DatastoreFacade.verifyCustomer("20", "20"));
	}
	
	@Test
	public void testNotVerifyCustomer() {
		assertFalse("should not be the same user", DatastoreFacade.verifyCustomer("20", "999"));
	}

	@Test
	public void testAddCustomer() {
		Customer customer = new Customer("25", "Hello", "World", "hello.world@example.com", "FIU", "Car");
		Customer customer2 = null;
		DatastoreFacade.addCustomer(customer);
		
		EntityManager mgr = getEntityManager();
        try {
            customer2 = mgr.find(Customer.class, "25");
        } finally {
        	mgr.close();
        }
        sameCustomer(customer, customer2);
	}

	@Test
	public void testFetchCustomer() {
	    Customer cust1 = new Customer("20", "Foo", "Bar", "foo.bar@example.com", "FIU", "Car");
	    Customer cust2 = DatastoreFacade.fetchCustomer("20");
	    sameCustomer(cust1, cust2);
	}
	
	@Test
	public void testNullFetchCustomer() {
		Customer cust = DatastoreFacade.fetchCustomer("999");
		assertNull("Should be a null customer", cust);
	}

	@Test
	public void testListCustomers() {
	    Customer cust1 = new Customer("20", "Foo", "Bar", "foo.bar@example.com", "FIU", "Car");
	   
		List<Customer> customers = DatastoreFacade.listCustomers(null, null);
		for(Customer cust: customers) {
			sameCustomer(cust1, cust);
		}
	}

	@Test
	public void testUpdateCustomer() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddCarpool() {
		fail("Not yet implemented");
	}

	@Test
	public void testListCarpools() {
		fail("Not yet implemented");
	}

	@Test
	public void testFetchCarpool() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdateCarpool() {
		fail("Not yet implemented");
	}

	@Test
	public void testRemoveCarpool() {
		fail("Not yet implemented");
	}

	@Test
	public void testIsRider() {
		fail("Not yet implemented");
	}
	
	private static EntityManager getEntityManager() {
		return EMF.get().createEntityManager();
	}

}
