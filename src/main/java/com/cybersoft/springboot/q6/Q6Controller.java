package com.cybersoft.springboot.q6;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/q6")
public class Q6Controller {

    @GetMapping("/filters")
    public ResponseEntity<Map<String, String>> getFilteredData(@RequestParam Map<String, String> filters) {
        System.out.println("Received filters:");
        filters.forEach((key, value) -> {
            System.out.println(key + " : " + value);
        });

        return ResponseEntity.ok().body(filters);
    }
}
