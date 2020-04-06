package com.todo.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
@Slf4j
@Controller
public class SimpleController {

    @GetMapping(path = "/hello")
    @ResponseBody
    public String sayHello(){
        return "hello";
    }

    @GetMapping("welcome")
    public String welcomePage(@RequestParam String user,  Model model){
        model.addAttribute("user",user);
        //Log.info("model: {}",model );
        System.out.println("########### model:"+model);
        return "welcome";

    }

    @ModelAttribute("welcomemsg")
    public String welcomemsg(){
       // Log.info("welcomeMsg called" );
        System.out.println("welcomemsg called");
        return "welcome to the site!!";
    }
}
