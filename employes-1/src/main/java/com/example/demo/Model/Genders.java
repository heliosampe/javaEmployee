package com.example.demo.Model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="GENDERS")
public class Genders implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @Column(name = "ID")
	private int idGenders;

	 @Column(name = "NAME")
		private String name;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIdGenders() {
		return idGenders;
	}

	public void setIdGenders(int idGenders) {
		this.idGenders = idGenders;
	}
	 
}