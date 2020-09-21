package com.example.demo.Model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "GENDERS")
public class Genders implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	private int idGenders;

	@Column(name = "NAME")
	private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "genders")
    private List<Employees> employees;

	public Genders(int idGenders) {
		this.idGenders = idGenders;
	}
	public Genders() {
	}

	public int getIdGenders() {
		return idGenders;
	}

	public void setIdGenders(int idGenders) {
		this.idGenders = idGenders;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employees> getEmployees() {
		return employees;
	}

	public void setEmployees(List<Employees> employees) {
		this.employees = employees;
	}


}