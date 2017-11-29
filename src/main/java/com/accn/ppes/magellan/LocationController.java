package com.accn.ppes.magellan;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/api")
public class LocationController {
	
	protected Locationservice locationservice;
	
	@Autowired
	public LocationController(Locationservice locationservice) {
		this.locationservice = locationservice;
	}
	 @RequestMapping(method = RequestMethod.GET)
	    public @ResponseBody String index(){
	            return "Welcome to APP PES Location API";

	    }
	@RequestMapping(value = "/location/{locationNumber}", method = RequestMethod.GET)
	public @ResponseBody Location byNumber( @PathVariable("locationNumber") Long id) {
		Location locationcount = locationservice.getLocationById(id);

		if (locationcount == null)
			throw new com.accn.ppes.magellan.exception.LocationNotFoundException(id);
		else {
			return locationcount;
		}
	}

	@RequestMapping(value = "/location/getLocationByName/{locationName}", method = RequestMethod.GET)
	public @ResponseBody Location byName(@PathVariable("locationName") String locationName) {
		Location locationcount = locationservice.getLocationByName(locationName);
		return locationcount;

	}
	
	@RequestMapping(value = "/location", method = RequestMethod.GET)
	public @ResponseBody Collection<Location> getAlllocation(){
		Collection<Location> locations = locationservice.getAllLocation();
		return locations;
		
	}

   @RequestMapping(value = "/location", method = RequestMethod.POST)
   public @ResponseBody Location create(@RequestBody Location location) {
	   System.out.println(location.toString());
	   Location createdLocation = locationservice.saveLocation(location);
    	return createdLocation;
    }
   
   @RequestMapping(value = "/location/deleteByLocationId/{locationNumber}", method = RequestMethod.DELETE)
	public @ResponseBody String deletebyNumber( @PathVariable("locationNumber") Long id) {
		String result = locationservice.deleteLocation(id);

		if (result == null)
			throw new com.accn.ppes.magellan.exception.LocationNotFoundException(id);
		else {
			return result;
		}
	}
   @RequestMapping(value = "/location/deleteByLocationName/{locationName}", method = RequestMethod.DELETE)
	public @ResponseBody String deletebyLocationName( @PathVariable("locationName") String locationName) {
		String result = locationservice.deleteLocationByName(locationName);

		if (result == null)
			throw new com.accn.ppes.magellan.exception.LocationNotFoundException();
		else {
			return result;
		}
	}
   
   
   
   
   @RequestMapping(value = "/location/updateByLocationById", method = RequestMethod.PUT)
   public @ResponseBody Location update(@RequestBody Location location) {
	   System.out.println(location.toString());
	   if(location.getLocationId() != null )
	   {
		   location.setLocationId(location.getLocationId());
	   }
	   System.out.println("\n \n"+location.getLocationId()+"\n \n");
	    Location created = locationservice.updateLocation(location);
    	return created;
    }
   
   @RequestMapping(value = "/state", method = RequestMethod.POST)
   public @ResponseBody State create(@RequestBody State state) {
	   System.out.println(state.toString());
	   State createdState = locationservice.saveState(state);
    	return createdState;
    }
   
   @RequestMapping(value = "/location/getLocationByState/{statename}", method = RequestMethod.GET)
	public @ResponseBody Set<Location> getByState( @PathVariable("statename") String statename) {
	   Set<Location> location = locationservice.getByStateName(statename);
		return location;
	}
   
   @RequestMapping(value = "/region", method = RequestMethod.POST)
   public @ResponseBody Region create(@RequestBody Region region) {
	   System.out.println(region.toString());
	   Region createdRegion = locationservice.saveRegion(region);
    	return createdRegion;
    }
   
   @RequestMapping(value = "/region/getStateByRegion/{regionname}", method = RequestMethod.GET)
	public @ResponseBody Set<State> getByRegion( @PathVariable("regionname") String regionname) {
	   Set<State> states = locationservice.getByRegionName(regionname);
		return states;
	}
   
   @RequestMapping(value = "/country", method = RequestMethod.POST)
   public @ResponseBody Country create(@RequestBody Country country) {
	   System.out.println(country.toString());
	   Country createdCountry = locationservice.saveCountry(country);
	   return createdCountry;
    }
   
   @RequestMapping(value = "/region/getRegionBycountry/{countryname}", method = RequestMethod.GET)
	public @ResponseBody Set<Region> getByCountry( @PathVariable("countryname") String countryname) {
	   Set<Region> regions = locationservice.getByCountryName(countryname);
		return regions;
	}
   
}
