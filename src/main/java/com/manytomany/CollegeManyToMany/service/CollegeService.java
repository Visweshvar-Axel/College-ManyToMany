package com.manytomany.CollegeManyToMany.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manytomany.CollegeManyToMany.entity.College;
import com.manytomany.CollegeManyToMany.entity.Student;
import com.manytomany.CollegeManyToMany.repository.CollegeRepo;
import com.manytomany.CollegeManyToMany.repository.StudentRepo;

import java.util.*;

@Service
public class CollegeService {
    @Autowired
    CollegeRepo collegeRepo;
    @Autowired
    StudentRepo studentRepo;

    public List<College> getAllColleges() {
        return collegeRepo.findAll();
    }

    public List<Student> getAllStudents() {
        return studentRepo.findAll();
    }

    public College CreateCollege(College college) {
        return collegeRepo.save(college);
    }

    public College CreateCollege(Long studentId, College college) {
        Optional<Student> student = studentRepo.findById(studentId);
        if (student.isPresent()) {
            student.get().addColleges(college);
            college.addStudents(student.get());
            return collegeRepo.save(college);
        }
        return null;
    }

    public Student CreateStudent(Long CollegeId, Student student) {
        Optional<College> college = collegeRepo.findById(CollegeId);
        if (college.isPresent()) {
            student.addColleges(college.get());
            college.get().addStudents(student);
            return studentRepo.save(student);
        }
        return null;
    }
}