package com.accn.ppes.magellan;

import java.util.Collection;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;

import com.accn.ppes.magellan.Location;
import com.accn.ppes.magellan.Locationservice;



@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@ActiveProfiles("test")
public class LocationserviceTest  extends AbstractTest{

	@Autowired
	private Locationservice service;
	
    @Test
    public void test1Create() {

    	Location entity = new Location();
    	entity.setLocationName("US");

        Location secondentity = new Location();
     	secondentity.setLocationName("IN");
         
     	Location createdEntity = service.saveLocation(entity);
        service.saveLocation(secondentity);
        Assert.assertNotNull("failure - expected not null", createdEntity);
        Assert.assertNotNull("failure - expected id attribute not null"+createdEntity.getLocationId(),
                createdEntity.getLocationId());
        Assert.assertEquals("failure - expected Product Name attribute match", "US",
                createdEntity.getLocationName());

        Collection<Location> list = service.getAllLocation();

        Assert.assertEquals("failure - expected size", 2, list.size());
    }
	
	  @Test
	    public void test2FindAll() {

	        Collection<Location> list = service.getAllLocation();

	        Assert.assertNotNull("failure - expected not null", list);
	        Assert.assertEquals("failure - expected list size", 2, list.size());

	    }
	  
	@Test
    public void test3FindOne() {

        Long id = new Long(1);

        Location entity = service.getLocationById(id);

        Assert.assertNotNull("failure - expected not null", entity);
        Assert.assertEquals("failure - expected id attribute match", id,
                entity.getLocationId());

    }

    
    @Test
    public void test4Update() {

        Long id = new Long(1);

        Location entity = service.getLocationById(id);

        Assert.assertNotNull("failure - expected not null", entity);

        String updatedText = "PARKER";
        entity.setLocationName(updatedText);
        Location updatedEntity = service.updateLocation(entity);

        Assert.assertNotNull("failure - expected not null", updatedEntity);
        Assert.assertEquals("failure - expected id attribute match", id,
                updatedEntity.getLocationId());
        Assert.assertEquals("failure - expected text attribute match",
                updatedText, updatedEntity.getLocationName());

    }


    @Test
    public void test5Delete() {

        Long id = new Long(1);

        Collection<Location> entities = service.getAllLocation();
        
        Location entity = service.getLocationById(id);
        
        System.out.println(entities.toString());

        Assert.assertNotNull("failure - expected not null", entity);

        service.deleteLocation(id);

        Collection<Location> list = service.getAllLocation();

        Assert.assertEquals("failure - expected size", 1, list.size());


    }
}
