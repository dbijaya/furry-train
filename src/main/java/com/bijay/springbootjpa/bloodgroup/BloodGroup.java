package com.bijay.springbootjpa.bloodgroup;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class BloodGroup {
	
	@Id
	private Integer id;
	private String bloodGroup;
	
	public BloodGroup() {
		
	}
	
	public BloodGroup(Integer id, String bloodGroup) {
		super();
		this.id = id;
		this.bloodGroup = bloodGroup;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
}
