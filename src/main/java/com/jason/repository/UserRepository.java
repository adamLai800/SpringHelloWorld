package com.jason.repository;

import com.jason.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

//import org.springframework.stereotype.Repository;
//
//@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Integer> {

//    @Query("SELECT u FROM User u WHERE u.status = 1")
//    Collection<User> findAllActiveUsers();


}
