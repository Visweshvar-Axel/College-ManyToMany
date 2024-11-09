package com.manytomany.CollegeManyToMany.entity;

import jakarta.persistence.*;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class College {
    @Id
    @GeneratedValue
    Long id;
    String name;
    @ManyToMany(mappedBy = "colleges")
    @JsonIgnore
    List<Student> students = new ArrayList<>();

    public College() {
    }

    public College(Long id, String name, List<Student> students) {
        this.id = id;
        this.name = name;
        this.students = students;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void addStudents(Student students) {
        this.students.add(students);
    }

}
