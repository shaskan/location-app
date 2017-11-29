package com.accn.ppes.magellan;

import java.util.Collection;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationUtility implements Locationservice {
	
	@Autowired
	LocationRespository locationRespository;
	
	@Autowired
	StateRepository stateRespository;
	
	@Autowired
	RegionRepository regionRespository;
	
	@Autowired
	CountryRepository countryRespository;
	
	
	@Override
	public Location getLocationById(long id) {
		// TODO Auto-generated method stub
		Location locationcount = locationRespository.findBylocationId(id);

		if (locationcount == null)
			throw new com.accn.ppes.magellan.exception.LocationNotFoundException(id);
		else {
			return locationcount;
		}
	}
	
	@Override
	public Location saveLocation(Location location) {
		try {
			location.setStateId(stateRespository.findByStateName(location.getStateName()));
			location = locationRespository.save(location);	
			return location;
		} catch (Exception e) {
			throw new com.accn.ppes.magellan.exception.LocationNotFoundException(location.locationId);
		}
		
		
	}
	
	@Override
	public String deleteLocation(Long id) {
		// TODO Auto-generated method stub
		   try {
			   locationRespository.delete(id);	
				} catch (Exception e) {
					throw new com.accn.ppes.magellan.exception.LocationNotFoundException(id);
				}
				return "location deleted!";
	}
	
	@Override
	public Location updateLocation(Location location) {
		// TODO Auto-generated method stub
		try {
			location = locationRespository.save(location);	
			
				} catch (Exception e) {
					throw new com.accn.ppes.magellan.exception.LocationNotFoundException(location.getLocationId());
				}
				return location;
	}

	@Override
	public Collection<Location> getAllLocation() {
		// TODO Auto-generated method stub
		Collection<Location> locations = locationRespository.findAll();

        return locations;
	}

	@Override
	public Location getLocationByName(String locationName) {
		// TODO Auto-generated method stub
		Location location = locationRespository.findByLocationName(locationName);
		return location;
	}

	@Override
	public String deleteLocationByName(String locationName) {
		// TODO Auto-generated method stub
		try {
			Location location = locationRespository.findByLocationName(locationName);
			locationRespository.delete(location);	
				} catch (Exception e) {
					throw new com.accn.ppes.magellan.exception.LocationNotFoundException();
				}
				return "Location deleted!";
		
		
	}
	
	@Override
	public State saveState(State state) {
		try {
			state.setRegionId(regionRespository.findByRegionName(state.getRegionName()));
			state = stateRespository.save(state);	
			return state;
		} catch (Exception e) {
			throw new com.accn.ppes.magellan.exception.LocationNotFoundException(state.stateId);
		}
	}
	
	@Override
	public Set<Location> getByStateName(String statename) {
		// TODO Auto-generated method stub
		return locationRespository.findByStateName(statename);
	}
	
	@Override
	public Region saveRegion(Region region) {
		try {
			region.setCountryId(countryRespository.findByCountryName(region.getCountryName()));
			region = regionRespository.save(region);	
			return region;
		} catch (Exception e) {
			throw new com.accn.ppes.magellan.exception.LocationNotFoundException(region.regionId);
		}
	}
	
	@Override
	public Set<State> getByRegionName(String regionname) {
		// TODO Auto-generated method stub
		return stateRespository.findByRegionName(regionname);
	}
	
	@Override
	public Country saveCountry(Country country) {
		
			country = countryRespository.save(country);	
			return country;
	}
	
	@Override
	public Set<Region> getByCountryName(String countryname) {
		// TODO Auto-generated method stub
		return regionRespository.findByCountryName(countryname);
	}

}
