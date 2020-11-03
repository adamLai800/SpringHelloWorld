package com.jason.controller;

import com.jason.model.Student;
import com.jason.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/student") // This means URL's start with /adam (after Application path)
public class StudentController {
    @Autowired
    private StudentRepository StudentRepository;

    //Add
    @PostMapping(path = "/addNew") // Map ONLY POST Requests
    public @ResponseBody String addNew(
            @RequestParam String name,
            @RequestParam String sex) {

        Student student = new Student();
        student.setName(name);
        student.setSex(sex);
        StudentRepository.save(student);
        return "Saved";
    }

    @PostMapping(path = "/addNew2") // Map ONLY POST Requests
    public @ResponseBody String addNew2(@RequestBody Student student) {
        StudentRepository.save(student);
        return "Saved";
    }

    //Delete All
    @DeleteMapping(path = "/deleteAll") // Map ONLY Delete All Requests
    public @ResponseBody String deleteAll() {
        StudentRepository.deleteAll();
        return "Delete All";
    }

    //Delete By Id
    @DeleteMapping(path = "/deleteById") // Map ONLY Delete All Requests
    public @ResponseBody String deleteById(@RequestParam int id) {
        StudentRepository.deleteById(id);
        return "Delete All";
    }

    //Grt By Id
    @GetMapping(path = "/findById") // Map ONLY Get By Id Requests
    public @ResponseBody Optional<Student> findById(@RequestParam int id) {

        return StudentRepository.findById(id);
    }

    //Grt By Name
    @GetMapping(path = "/findByName") // Map ONLY Get By Id Requests
    public @ResponseBody
    List<Student> findByName(@RequestParam String name) {
        return StudentRepository.findByName(name);
    }

//    //TODO findAllById 不懂
//    public @ResponseBody Iterable<Student> getById(@RequestParam Iterable<Integer> id) {
//
//        return adamWriteStudentRepository.findAllById(id);
//    }

    //Get All Student
    @GetMapping(path = "/findAll") // Map ONLY Get By Student Requests
    public @ResponseBody Iterable<Student> findAll() {
        return StudentRepository.findAll();
    }

    //Update Name By Id
    @GetMapping(path = "/setFixedNameFor") // Map ONLY Get By Student Requests
    public @ResponseBody String setFixedNameFor(@RequestParam String name,
                                                       @RequestParam int id) {

        StudentRepository.setFixedNameFor(name,id);
        return "PUT OK";
    }
}