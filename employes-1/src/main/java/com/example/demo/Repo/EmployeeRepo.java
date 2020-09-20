package com.example.demo.Repo;

import javax.transaction.Transactional;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Employees;

@Repository
public interface EmployeeRepo extends JpaRepository<Employees, Integer> {

}
