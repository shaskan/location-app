package com.accn.ppes.magellan;

import org.springframework.data.repository.Repository;


public interface CountryRepository extends Repository<Country, Long>  {
	
	public Country save(Country saved);
	public Country findByCountryName(String countryName);
	

}
