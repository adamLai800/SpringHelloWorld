package com.jason.repository;

import com.jason.model.NameTotal;
import com.jason.model.Score;
import com.jason.model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

public interface ScoreRepository extends CrudRepository<Score, Integer> {

//    List<Lesson> findBySubject(String subject);

    @Modifying
    @Transactional
    @Query(value = "UPDATE score SET score = ? WHERE id = ? AND lid = ? ", nativeQuery = true)
    void setFixedSubjectFor(double score, int id , String lid);

//    @Query(value = "SELECT MAX(score) FROM score WHERE sid = ?", nativeQuery = true)
//    Double getMax(String sid);
    @Query(value = "SELECT name, SUM(score) FROM student " +
            "LEFT JOIN score ON student.id = score.sid GROUP BY name ", nativeQuery = true)
    ArrayList<NameTotal> findByNameTotal3();

}

