package com.example.demo.Model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
	private Integer idEmployes;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "BIRTHDATE")
	private Date birthname;
	
	//bi-directional many-to-one association to gender
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="GENDER_ID",nullable = false)
	private Genders genders;
	
	//bi-directional many-to-one association to jobs
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="JOB_ID",nullable = false)
	private Jobs job;
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employees")
	private List<EmployeeWorkedHours> employeeWorkedHours;
	
	
	
	

	public List<EmployeeWorkedHours> getEmployeeWorkedHours() {
		return employeeWorkedHours;
	}


	public void setEmployeeWorkedHours(List<EmployeeWorkedHours> employeeWorkedHours) {
		this.employeeWorkedHours = employeeWorkedHours;
	}


	public Employees() {
	
	}
	

	public Employees(Integer idEmployes) {
		this.idEmployes = idEmployes;
	}


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

	public Genders getGenders() {
		return genders;
	}

	public void setGenders(Genders genders) {
		this.genders = genders;
	}

	public Jobs getJob() {
		return job;
	}

	public void setJob(Jobs job) {
		this.job = job;
	}

	
//	@Column(name = "JOB_ID")
//	private int jobId;


	


	
}