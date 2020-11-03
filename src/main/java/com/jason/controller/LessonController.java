package com.jason.controller;

import com.jason.model.Lesson;
import com.jason.repository.LessonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/lesson") // This means URL's start with /adam (after Application path)
public class LessonController {

    @Autowired
    private LessonRepository LessonRepository;

    //Add
    @PostMapping(path = "/addNew") // Map ONLY POST Requests
    public @ResponseBody String addNew(
            @RequestParam String lid,
            @RequestParam String subject) {

        Lesson lesson = new Lesson();
        lesson.setLid(lid);
        lesson.setSubject(subject);
        LessonRepository.save(lesson);
        return "Saved";
    }

    @PostMapping(path = "/addNew") // Map ONLY POST Requests
    public @ResponseBody String addNew(@RequestBody Lesson lesson) {
        LessonRepository.save(lesson);
        return "Saved";
    }

    //Delete All
    @DeleteMapping(path = "/deleteAll") // Map ONLY Delete All Requests
    public @ResponseBody String deleteAll() {
        LessonRepository.deleteAll();
        return "Delete All";
    }

    //Delete By Lid
    @DeleteMapping(path = "/deleteByLid") // Map ONLY Delete All Requests
    public @ResponseBody String deleteByLid(@RequestParam String lid) {
        LessonRepository.deleteById(lid);
        return "Delete All";
    }

    //Grt By Lid
    @GetMapping(path = "/findByLid") // Map ONLY Get By Id Requests
    public @ResponseBody Optional<Lesson> findByLid(@RequestParam String lid) {

        return LessonRepository.findById(lid);
    }

    //Grt By Subject
    @GetMapping(path = "/findBySubject") // Map ONLY Get By Id Requests
    public @ResponseBody
    List<Lesson> findBySubject(@RequestParam String lid) {
        return LessonRepository.findBySubject(lid);
    }

    //Get All Lesson
    @GetMapping(path = "/findAll") // Map ONLY Get By Student Requests
    public @ResponseBody Iterable<Lesson> findAll() {
        return LessonRepository.findAll();
    }

    //Update Subject By Lid
    @GetMapping(path = "/setFixedSubjectFor") // Map ONLY Get By Student Requests
    public @ResponseBody String setFixedSubjectFor(@RequestParam String subject,
                                                   @RequestParam String lid) {

        LessonRepository.setFixedSubjectFor(subject, lid);
        return "PUT OK";
    }
}

