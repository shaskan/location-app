package com.accn.ppes.magellan;

import java.util.Collection;
import java.util.Set;

public interface Locationservice {
		public Location getLocationById(long id);
		public Location saveLocation(Location location);
		public Collection<Location> getAllLocation();
		public Location updateLocation(Location location);
		public String deleteLocation(Long id);
		public Location getLocationByName(String locationName);
		public String deleteLocationByName(String locationName);

		public State saveState(State state);
		public Set<Location> getByStateName(String statename);
		
		public Region saveRegion(Region region);
		public Set<State> getByRegionName(String regionname);
		
		public Country saveCountry(Country country);
		public Set<Region> getByCountryName(String countryname);
}
