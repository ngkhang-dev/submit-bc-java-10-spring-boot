package com.cybersoft.springboot.q5;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/q5")
public class Q5Controller {

    private final Q5Service q5Service;

    public Q5Controller(Q5Service q5Service) {
        this.q5Service = q5Service;
    }

    @GetMapping("/tags")
    public ResponseEntity<List<String>> getListTags (@RequestParam String tags) {
        List<String> taqs = q5Service.getListTags(tags);
        return ResponseEntity.ok().body(taqs);
    }
}
