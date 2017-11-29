package com.accn.ppes.magellan;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "State")
public class State {

	@Id
	@GeneratedValue
	@Column(name = "stateid")
	protected Long stateId;
	
	@Column(name = "statename")
	protected String stateName;
	
	@Column(name = "statedescription")
	protected String stateDescription;
	

	public String getStateDescription() {
		return stateDescription;
	}

	public void setStateDescription(String stateDescription) {
		this.stateDescription = stateDescription;
	}

	@ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
	@JoinColumn(name = "regionid", nullable = false)
	@JsonBackReference("Region")
	protected Region regionId;
	
	@Column(name = "regionname")
	protected String regionName;
	
/*	@OneToMany(mappedBy = "state",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JsonManagedReference("state")
	private Set<Location> locations = new HashSet<Location>();*/

	public Long getStateId() {
		return stateId;
	}

	public Region getRegionId() {
		return regionId;
	}

	public void setRegionId(Region regionId) {
		this.regionId = regionId;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public void setStateId(Long stateId) {
		this.stateId = stateId;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

}
