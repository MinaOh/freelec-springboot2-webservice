package com.jojoldu.book.springboot.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //json으로 반환하는 controller
public class HelloController {
    @GetMapping("/hello") //GET 요청을 받을 수 있는 API
    public String hello(){
        return "hello";
    }
}
