package com.zetcode.demo.userRepository;

import java.util.List;

import com.zetcode.demo.Users;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Users, Long> {

    List<Users> findByName(String name);

    Users findById(long id);
}