package com.p2p.server.p2p_backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.p2p.server.p2p_backend.repository.UserRepository;

@RestController
public class TestController {

    @GetMapping("/ping")
    public String ping() {
        System.out.println("yah");
        return "pong";
    }

}
