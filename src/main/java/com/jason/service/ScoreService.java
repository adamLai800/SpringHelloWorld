package com.jason.service;

import com.jason.model.Score;
import com.jason.model.Student;
import com.jason.repository.ScoreRepository;
import com.jason.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service
public class ScoreService {

    //T取得最高分數的科目
    @Autowired
    public StudentRepository studentRepository;

    @Autowired
    public ScoreRepository scoreRepository;

//    public double getMax(String requestName) {
//        double max = 0.0;
//        Iterable<Student> students = studentRepository.findAll();
//        HashMap<Integer, Student> studentMap = new HashMap<Integer, Student>();
//        for(Student student : students) {
//            studentMap.put(student.getId(), student);
//        }
//
//        HashMap<Integer, List<Score>> scoreMap = new HashMap<Integer, List<Score>>();
//        Iterable<Score> scores = scoreRepository.findAll();
//        Iterator iterator = studentMap.keySet().iterator();
//        while (iterator.hasNext()) {
//            int key = (Integer) iterator.next();
//            System.out.println("student key : " + key);
//            List<Score> scoresList = new ArrayList<Score>();
//            for(Score score: scores) {
//                System.out.println("===> score2 : " + score.getScore());
//                if(key == Integer.parseInt(score.getSid())) {
//                    System.out.println("lid : " + score.getLid());
//                    System.out.println("score : " + score.getScore());
//                    scoresList.add(score);
//                }
//            }
//            scoreMap.put(key, scoresList);
//        }
//
//        System.out.println("======> level 2");
//
//        HashMap<String, List<Score>> nameMap = new HashMap<String, List<Score>>();
//        Iterator newIterator = studentMap.keySet().iterator();
//        while (newIterator.hasNext()) {
//            int key = (Integer) newIterator.next();
//            Student student = studentMap.get(key);
//            System.out.println("name : " + student.getName());
//            List<Score> scores1 = scoreMap.get(key);
//            nameMap.put(student.getName(), scores1);
//            for(Score score : scores1) {
//                System.out.println("lid : " + score.getLid());
//                System.out.println("score : " + score.getScore());
//            }
//        }
//
//
//
//
//        System.out.println("======> level 3");
//
//        List<Score> scoreList = nameMap.get(requestName);
//        int count = 0;
//        for(Score score : scoreList) {
//            double studentScore = score.getScore();
//            System.out.println("score : " + studentScore);
//            if(count == 0) {
//                max = studentScore;
//            } else {
//                if (studentScore > max) {
//                    max = studentScore;
//                }
//            }
//            count = count + 1;
//        }
//        return max;
//    }
//
//    public Double getMax2(String requestName) {
//        double max = 0.0;
//
//        String sid = "";
//        List<Student> students = studentRepository.findByName(requestName);
//        for(Student student : students) {
//            System.out.println("student name : " + student.getName());
//            sid = String.valueOf(student.getId());
//        }
//
//        List<Student> students2 = studentRepository.findByStudentName(requestName);
//        for(Student student : students2) {
//            System.out.println("student name : " + student.getName());
//            sid = String.valueOf(student.getId());
//        }
//
//        max = scoreRepository.getMax(sid);
//
//        return max;
//    }
    // findByNameTotal
    public HashMap<String, Double> findByNameTotal() {
        HashMap<String, Double> nameotal = new HashMap<String, Double>();

        Iterable<Student> students = studentRepository.findAll();
        HashMap<Integer, Student> studentMap = new HashMap<Integer, Student>();
        for(Student student : students) {
            studentMap.put(student.getId(), student);
        }
        HashMap<Integer, Double> scoreMap = new HashMap<Integer, Double>();
        Iterable<Score> scores = scoreRepository.findAll();
        Iterator iterator = studentMap.keySet().iterator();
        while (iterator.hasNext()) {
            int key = (Integer) iterator.next();
            Student student = studentMap.get(key);
            Double Total = 0.00;
            for(Score score: scores) {
                if(key == Integer.parseInt(score.getSid())) {
                    Total = Total + score.getScore();
                }
            }
//            System.out.println("name : " + student.getName());
//            System.out.println("total : " + Total);
            nameotal.put(student.getName(), Total);
        }
        return nameotal;
    }
}
