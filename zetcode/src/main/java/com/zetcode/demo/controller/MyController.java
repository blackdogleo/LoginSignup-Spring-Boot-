package com.zetcode.demo.controller;


import com.zetcode.demo.Users;
import com.zetcode.demo.mybean.LogUser;
import com.zetcode.demo.bean.User;
import com.zetcode.demo.userRepository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class MyController {

    @GetMapping("/addUser")
    public String sendForm(User user) {

        return "addUser";
    }

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();/*Implementing Encryption Using Bcrypt*/
    @Autowired //don't forget the setter
    private UserRepository repository;
    @PostMapping("/addUser")
    public  String  processForm(User user,Model model){
        // save a few customers
        if(user.name.isEmpty() || user.pass.isEmpty()){return "error1";
        }
        else {
            try{
            Users userexists = repository.findByName(user.name).get(0);
            if(!userexists.toString().isEmpty()){
                return "userexists";
            }

        }catch(IndexOutOfBoundsException e){
                System.out.println("exception occured"+e.toString());
                repository.save(new Users(user.name, passwordEncoder.encode(user.pass)));
                model.addAttribute("loguser", new LogUser());
                return "redirect:userLogin";
            }


    }
        return "";

    }
    @GetMapping("/userLogin")
    public String userLogin(Model model){
        model.addAttribute("loguser", new LogUser());
        return "login";
    }
    @PostMapping("/userLogin")
    public String processUser(LogUser loguser,Model model) {
        if (loguser.uname.equals("")) {

            return "redirect:userLogin";
        } else {try{
            Users pass = repository.findByName(loguser.uname).get(0);
            if (pass.toString().isEmpty()) {/* if pass provided is emplty*/

                return "redirect:userLogin";
            } else{
                String tpass = pass.toString();
            String sep = "pass=";
            int sepPos = tpass.indexOf(sep);
            tpass = tpass.substring(sepPos + sep.length());
            tpass = tpass.replaceAll("'","");
            tpass = tpass.replaceAll("]","");

            System.out.println(tpass);



            if (passwordEncoder.matches(loguser.upass,tpass)) {

                return "plogin";

            } else {
                model.addAttribute("loguser", new LogUser());

                return "invalidCreds";
            }

        }
    }catch(IndexOutOfBoundsException e){

            System.out.println("exception occured"+e.toString());
            return "redirect:userLogin";

        }

        }


        }
    }

