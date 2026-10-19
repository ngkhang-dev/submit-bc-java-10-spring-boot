package com.cybersoft.springboot.q3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/q3")
public class Q3Controller {

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUserById(@PathVariable String id,
                                         @RequestHeader("X-Client-Version") String xClientVersion) {

        return ResponseEntity.ok().body("User with id: " + id + " and X-Client-Version: " + xClientVersion);
    }
}
