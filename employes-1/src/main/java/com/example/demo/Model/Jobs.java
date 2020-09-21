package com.example.demo.Model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "job")
    private List<Employees> employees;
	

	public Jobs(int idJobs) {

		this.idJobs = idJobs;
	}
	
	public Jobs() {
	}

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

	public List<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}
	

	
	

}