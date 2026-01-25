package com.p2p.server.p2p_backend.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.p2p.server.p2p_backend.repository.LocationRepository;
import java.util.*;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationRepository repository;

    public LocationController(LocationRepository repo) {
        this.repository = repo;
    }

    @GetMapping("/{id}")
    public String getLocation(@PathVariable String id) {
        Map<String, String> m = new HashMap<>();
        m.put("hello", "world");
        return "hello world";
    }
}
