package com.jason.controller;

import com.jason.model.NameTotal;
import com.jason.model.Score;
import com.jason.model.Student;
import com.jason.repository.ScoreRepository;
import com.jason.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Optional;

@Controller // This means that this class is a Controller
@RequestMapping(path="/score") // This means URL's start with /adam (after Application path)
public class ScoreController{

    @Autowired
    private ScoreRepository ScoreRepository;

    @Autowired
    public ScoreService scoreService;

    //Add
    @PostMapping(path = "/addNew") // Map ONLY POST Requests
    public @ResponseBody
    String addNew(
            @RequestParam String sid,
            @RequestParam String lid,
            @RequestParam Double score) {

        Score scores = new Score();
        scores.setSid(sid);
        scores.setLid(lid);
        scores.setScore(score);
        ScoreRepository.save(scores);
        return "Saved";
    }
    @PostMapping(path = "/addNew2") // Map ONLY POST Requests
    public @ResponseBody
    String addNew2(@RequestBody Score score) {

        ScoreRepository.save(score);
        return "Saved";
    }
    //Delete All
    @DeleteMapping(path = "/deleteAll") // Map ONLY Delete All Requests
    public @ResponseBody String deleteAll() {
        ScoreRepository.deleteAll();
        return "Delete All";
    }

    //Delete By Id
    @DeleteMapping(path = "/deleteByLid") // Map ONLY Delete All Requests
    public @ResponseBody String deleteByLid(@RequestParam int id) {
        ScoreRepository.deleteById(id);
        return "Delete All";
    }

    //Grt By Id
    @GetMapping(path = "/findByLid") // Map ONLY Get By Id Requests
    public @ResponseBody
    Optional<Score> findByLid(@RequestParam int id) {

        return ScoreRepository.findById(id);
    }

//    //Grt By Name
//    @GetMapping(path = "/findBySubject") // Map ONLY Get By Id Requests
//    public @ResponseBody
//    List<Lesson> findBySubject(@RequestParam String lid) {
//        return LessonRepository.findBySubject(lid);
//    }

    //Get All Student
    @GetMapping(path = "/findAll") // Map ONLY Get By Student Requests
    public @ResponseBody Iterable<Score> findAll() {
        return ScoreRepository.findAll();
    }

    //Update Score By Id And Lid
    @GetMapping(path = "/setFixedScoreFor") // Map ONLY Get By Student Requests
    public @ResponseBody String setFixedSubjectFor(
            @RequestParam double score,
            @RequestParam int id,
            @RequestParam String lid) {

        ScoreRepository.setFixedSubjectFor(score, id, lid);
        return "PUT OK";
    }

//    @GetMapping(path = "/getMaxByName")
//    public @ResponseBody Double getMaxByName(@RequestParam String name) {
//        return scoreService.getMax(name);
//    }
//
//    @GetMapping(path = "/getMaxByName2")
//    public @ResponseBody Double getMaxByName2(@RequestParam String name) {
//        return scoreService.getMax2(name);
//    }
      @GetMapping(path = "/findByNameTotal")
      public @ResponseBody HashMap<String, Double> findByNameTotal() {
        return scoreService.findByNameTotal();
    }
    @GetMapping(path = "/findByNameTotal2")
    public @ResponseBody ArrayList<NameTotal> findByNameTotal2() {
        HashMap<String, Double> nametotal = scoreService.findByNameTotal();
        ArrayList<NameTotal> nametotals = new ArrayList<NameTotal>();
        Iterator  iterator = nametotal.keySet().iterator();
        while (iterator.hasNext()){
            NameTotal nametotalss = new NameTotal();
            String key = (String)iterator.next();
            nametotalss.setName(key);
            nametotalss.setScore(nametotal.get(key));
            nametotals.add(nametotalss);
        }
        return nametotals;
    }
    @GetMapping(path = "/findByNameTotal3")
    public @ResponseBody ArrayList<NameTotal> findByNameTotal3() {
        return ScoreRepository.findByNameTotal3();
    }
}