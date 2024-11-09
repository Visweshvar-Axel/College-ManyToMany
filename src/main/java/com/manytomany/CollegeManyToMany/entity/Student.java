package com.manytomany.CollegeManyToMany.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Student {
    @Id
    @GeneratedValue
    Long id;
    String name;
    // @jointable side
    @ManyToMany
    @JoinTable(name = "join_college", joinColumns = @JoinColumn(name = "std"), inverseJoinColumns = @JoinColumn(name = "clg"))
    List<College> colleges = new ArrayList<>();

    public Student() {
    }

    public Student(Long id, String name, List<College> colleges) {
        this.id = id;
        this.name = name;
        this.colleges = colleges;
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

    public List<College> getColleges() {
        return colleges;
    }

    public void addColleges(College colleges) {
        this.colleges.add(colleges);
    }

}
