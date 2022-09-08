package com.example.Springbootpractice.Controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @Value("${welcome.hello}")
    private String Hello;
    @GetMapping("/")
    public String helloWorld()
    {
        return Hello;
    }
}
