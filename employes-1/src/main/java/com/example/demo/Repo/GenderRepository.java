package com.example.demo.Repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Genders;

@Repository
public interface GenderRepository extends JpaRepository<Genders, Integer>{

}
