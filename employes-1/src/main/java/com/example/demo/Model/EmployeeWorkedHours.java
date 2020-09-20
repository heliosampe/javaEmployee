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

	// bi-directional many-to-one association to empleados
	//@OneToMany(fetch = FetchType.LAZY)
	//@JoinColumn(name = "EMPLOYEE_ID", nullable = false)
	@Column(name = "EMPLOYEE_ID")
	private int employeeId;

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

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	

}