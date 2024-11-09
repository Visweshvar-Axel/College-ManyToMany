package com.manytomany.CollegeManyToMany.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manytomany.CollegeManyToMany.entity.College;
import com.manytomany.CollegeManyToMany.entity.Student;
import com.manytomany.CollegeManyToMany.service.CollegeService;

@RestController
public class CollegeController {
    @Autowired
    CollegeService collegeService;

    @GetMapping("/colleges")
    public ResponseEntity<List<College>> getAllCollege() {
        List<College> res = collegeService.getAllColleges();
        return ResponseEntity.ok().body(res);
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> res = collegeService.getAllStudents();
        return ResponseEntity.ok().body(res);
    }

    @PostMapping("/colleges")
    public ResponseEntity<College> createCollege(@RequestBody College college) {
        College res = collegeService.CreateCollege(college);
        return ResponseEntity.ok().body(res);
    }

    @PostMapping("/colleges/{studentId}/")
    public ResponseEntity<College> createCollege(@PathVariable Long studentId, @RequestBody College college) {
        College res = collegeService.CreateCollege(studentId, college);
        return ResponseEntity.ok().body(res);
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestParam Long CollegeId, @RequestBody Student studentId) {
        Student res = collegeService.CreateStudent(CollegeId, studentId);
        return ResponseEntity.ok().body(res);
    }
}