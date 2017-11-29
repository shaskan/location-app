package com.accn.ppes.magellan;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface StateRepository extends Repository<State, Long> {
	
	public State save(State saved);
	public State findByStateName(String stateName);
	public Set<State> findByRegionName(String regionName);
	

}
