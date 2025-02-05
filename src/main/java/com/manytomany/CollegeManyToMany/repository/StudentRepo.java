package com.manytomany.CollegeManyToMany.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manytomany.CollegeManyToMany.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {

}
