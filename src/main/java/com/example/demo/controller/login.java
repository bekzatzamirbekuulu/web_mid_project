package com.example.demo.controller;

import com.example.demo.Repos;
import com.example.demo.form.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class login {

    @Autowired
    Repos repo;

    @GetMapping("/")
    public ModelAndView welcome(){
        ModelAndView model = new ModelAndView("index");
        return model;
    }

    @GetMapping("/login")
    public ModelAndView loginForm(){
        ModelAndView model = new ModelAndView("login");
        LoginForm log = new LoginForm();
        model.addObject("user", log);
        return model;
    }

    @RequestMapping(value = "/submitLogin", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute LoginForm loginForm) {
        String username = loginForm.getUsername();
        String password = loginForm.getPassword();
        ModelAndView model = new ModelAndView("home");
        model.addObject("user", loginForm);
        repo.save(loginForm);
        List<LoginForm> list = repo.findAll();
        model.addObject("users", list);
        return model;
    }
}
