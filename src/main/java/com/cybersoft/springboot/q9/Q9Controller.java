package com.cybersoft.springboot.q9;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/q9")
public class Q9Controller {

    @PutMapping("/users/{id}")
    public ResponseEntity<String> updateUserById(@PathVariable String id, @RequestBody Q9UpdateDTO updateDTO) {
        int idNumber = Integer.parseInt(id);
        boolean isUpdated = new Q9Service().updateUser(idNumber, updateDTO);

        if (!isUpdated) {
            return ResponseEntity.badRequest().body("Update failed!");
        }

        return ResponseEntity.ok().body("User with id: " + id + " updated successfully!");
    }
}
