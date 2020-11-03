package com.jason.model;

import javax.persistence.*;

@Entity
//@NamedQueries({
//        @NamedQuery(name="Student.findAll",
//                query="SELECT c FROM Student c"),
//        @NamedQuery(name="Country.findByName",
//                query="SELECT c FROM Country c WHERE c.name = :name"),
//})
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    private String name;

    private String sex;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
