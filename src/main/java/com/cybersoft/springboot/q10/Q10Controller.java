package com.cybersoft.springboot.q10;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/q10")
public class Q10Controller {

    @DeleteMapping("/posts/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id,
                                             @RequestHeader(required = false, value = HttpHeaders.AUTHORIZATION) String authToken) {

        if (authToken == null || authToken.trim().isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Authorization token is required!");
        }

        if (!authToken.startsWith("Bearer ") || authToken.split(" ").length != 2) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid authorization token format!");
        }

        return ResponseEntity.ok("Post deleted successfully! PostId: " + id + " - AuthToken: " + authToken);
    }
}
