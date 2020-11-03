package com.jason.repository;

import com.jason.model.Lesson;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;
import java.util.List;

public interface LessonRepository extends CrudRepository<Lesson, String> {

    List<Lesson> findBySubject(String subject);

    @Modifying
    @Transactional
    @Query(value = "UPDATE lesson SET subject = ? WHERE lid = ? ", nativeQuery = true)
    void setFixedSubjectFor(String subject, String lid);
}

