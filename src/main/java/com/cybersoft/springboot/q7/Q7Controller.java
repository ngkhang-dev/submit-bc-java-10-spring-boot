package com.cybersoft.springboot.q7;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/q7")
public class Q7Controller {

    @PostMapping(headers = "Content-Type=application/x-www-form-urlencoded", path = "/login-form")
    public ResponseEntity<String> loginForm(@RequestParam String username, @RequestParam String password) {

        return ResponseEntity.ok().body("Login successful! Username: " + username + "");
    }
}
