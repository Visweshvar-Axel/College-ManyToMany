package com.manytomany.CollegeManyToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manytomany.CollegeManyToMany.entity.College;

@Repository
public interface CollegeRepo extends JpaRepository<College, Long> {

}
