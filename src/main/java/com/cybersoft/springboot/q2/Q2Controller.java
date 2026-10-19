package com.cybersoft.springboot.q2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/q2")
public class Q2Controller {
    private final Q2Service q2Service;

    public Q2Controller(Q2Service q2Service) {
        this.q2Service = q2Service;
    }

    @PostMapping("/comments")
    public ResponseEntity<String> createComment(@RequestParam String postId, @RequestBody Q2CreateDTO createDTO) {
        int postIdNumber = Integer.parseInt(postId);

        String res = q2Service.createComment(postIdNumber, createDTO);

        return ResponseEntity.ok().body(res);
    }
}
