package com.accn.ppes.magellan;


import java.util.Collection;
import java.util.Set;

import org.springframework.data.repository.Repository;





public interface LocationRespository extends Repository<Location, Long> {
	
	public Location findBylocationId(Long locationId);
	public Location save(Location saved);
	public String delete(Long locationId);
	public Collection<Location> findAll();
	public Location findByLocationName(String locationName);
	public String delete(Location location);
	public Set<Location> findByStateName(String statename);
	
}