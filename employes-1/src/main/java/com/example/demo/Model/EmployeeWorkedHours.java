package com.example.demo.Model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE_WORKED_HOURS")
public class EmployeeWorkedHours implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private int idEmployeWorkedHours;

	@Column(name = "WORKED_HOURS")
	private int workedHours;

	@Column(name = "WORKED_DATE")
	private Date workedDate;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="EMPLOYEE_ID",nullable = false)
	private Employees employees;
	
	
	
	
	
	public EmployeeWorkedHours() {

	}

	public int getIdEmployeWorkedHours() {
		return idEmployeWorkedHours;
	}

	public void setIdEmployeWorkedHours(int idEmployeWorkedHours) {
		this.idEmployeWorkedHours = idEmployeWorkedHours;
	}

	public int getWorkedHours() {
		return workedHours;
	}

	public void setWorkedHours(int workedHours) {
		this.workedHours = workedHours;
	}

	public Date getWorkedDate() {
		return workedDate;
	}

	public void setWorkedDate(Date workedDate) {
		this.workedDate = workedDate;
	}

	public Employees getEmployees() {
		return employees;
	}

	public void setEmployees(Employees employees) {
		this.employees = employees;
	}




	

}