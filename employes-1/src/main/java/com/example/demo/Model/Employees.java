package com.example.demo.Model;


import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="EMPLOYEES")
public class Employees implements Serializable  {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
	private int idEmployes;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "BIRTHDATE")
	private Date birthname;
	
	//bi-directional many-to-one association to gender
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name="GENDER_ID",nullable = false)
	@Column(name = "GENDER_ID")
	private int genderId;
	
	
	//bi-directional many-to-one association to jobs
	//@ManyToOne(fetch = FetchType.LAZY)
	//@JoinColumn(name="JOB_ID",nullable = false)
	@Column(name = "JOB_ID")
	private int jobId;


	public int getIdEmployes() {
		return idEmployes;
	}


	public void setIdEmployes(int idEmployes) {
		this.idEmployes = idEmployes;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public Date getBirthname() {
		return birthname;
	}


	public void setBirthname(Date birthname) {
		this.birthname = birthname;
	}


	public int getGenderId() {
		return genderId;
	}


	public void setGenderId(int genderId) {
		this.genderId = genderId;
	}


	public int getJobId() {
		return jobId;
	}


	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	
	

	


	
}