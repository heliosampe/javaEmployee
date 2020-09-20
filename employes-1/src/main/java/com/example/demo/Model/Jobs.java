package com.example.demo.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="JOBS")
public class Jobs implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @Column(name = "ID")
	private int idJobs;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SALARY")
	private int salary;



	public int getIdJobs() {
		return idJobs;
	}

	public void setIdJobs(int idJobs) {
		this.idJobs = idJobs;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
	

	
	

}