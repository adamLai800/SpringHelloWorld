package com.jason.repository;

import com.jason.model.Student;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import javax.transaction.Transactional;
import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Integer> {

    List<Student> findByName(String name);

    @Query(value = "SELECT * FROM student where name = ?", nativeQuery = true)
    List<Student> findByStudentName(String name);

    @Modifying
    @Transactional
    @Query(value = "UPDATE student SET name = ? WHERE id = ? ", nativeQuery = true)
    void setFixedNameFor(String name, int id);
}
