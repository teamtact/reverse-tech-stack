package org.tact.base.mybatis.domain;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;

	private Long employerId;

	private String linkedin;

	private String skills;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Long getEmployerId() {
		return employerId;
	}


	public void setEmployerId(Long employerId) {
		this.employerId = employerId;
	}


	public String getLinkedin() {
		return linkedin;
	}


	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}


	public String getSkills() {
		return skills;
	}


	public void setSkills(String skills) {
		this.skills = skills;
	}


	@Override
	public String toString() {
		return getId() + "," + getEmployerId() + "," + getLinkedin() + "," + getSkills();
	}	
}