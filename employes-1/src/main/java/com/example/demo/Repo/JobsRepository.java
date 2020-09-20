package com.example.demo.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.Model.Jobs;


@Repository

public interface JobsRepository extends JpaRepository<Jobs, Integer> {

}
