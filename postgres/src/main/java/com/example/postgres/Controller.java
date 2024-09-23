package com.example.postgres;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class Controller {

    private final StudentsRepo studentsRepo;

    @GetMapping("/getStudents")
    public List<Students> getStudents() {
        return studentsRepo.findAll();
    }

    @PostMapping("/add")
    public Students addStudent(@RequestBody Students students) {
        return studentsRepo.save(students);
    }

    @PutMapping("/update")
    public Students updateStudent(@RequestBody Students updatedStudents) {
        Students students = studentsRepo.findById(updatedStudents.getId()).get();
        BeanUtils.copyProperties(updatedStudents, students);
        return studentsRepo.save(students);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        studentsRepo.deleteById(id);
        return ResponseEntity.ok("Deleted student");
    }
}
