package com.accn.ppes.magellan;

import java.util.Set;

import org.springframework.data.repository.Repository;

public interface RegionRepository extends Repository<Region, Long> {
	
	public Region save(Region saved);
	public Region findByRegionName(String regionName);
	public Set<Region> findByCountryName(String countryname);

}
