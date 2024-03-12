package com.example.sprintboothikaricp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    AsyncServiceImpl asyncService;

    @GetMapping("/test")
    public void insertTest() {
        asyncService.test();
    }

}
