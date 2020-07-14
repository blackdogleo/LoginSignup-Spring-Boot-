package com.zetcode.demo;
import java.util.ArrayList;
import java.util.List;

import com.zetcode.demo.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.zetcode.demo.Users;




@Service
public class UserService {
    @Autowired
    UserRepository userrepo;
    //getting all books record by using the method findaAll() of CrudRepository

    //getting a specific record by using the method findById() of CrudRepository
    public Users getBooksByName(String name)
    {
        return userrepo.findByName(name).get(1);
    }
    //saving a specific record by using the method save() of CrudRepository
    public void saveOrUpdate(Users users)
    {
        userrepo.save(users);
    }
    //deleting a specific record by using the method deleteById() of CrudRepository
    public void delete(Long id)
    {
        userrepo.deleteById(id);
    }
    //updating a record
    public void update(Users users, Long id)
    {
        userrepo.save(users);
    }
}
