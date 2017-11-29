package com.accn.ppes.magellan;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Country")
public class Country {
	
	@Id
	@GeneratedValue
	@Column(name = "countryid")
	protected Long countryId;
	
	@Column(name = "countrydescription")
	protected String countryDescription;
	
	@Column(name = "countryname")
	protected String countryName;

	public Long getCountryId() {
		return countryId;
	}

	public String getCountryDescription() {
		return countryDescription;
	}

	public void setCountryDescription(String countryDescription) {
		this.countryDescription = countryDescription;
	}

	public void setCountryId(Long countryId) {
		this.countryId = countryId;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}

}
