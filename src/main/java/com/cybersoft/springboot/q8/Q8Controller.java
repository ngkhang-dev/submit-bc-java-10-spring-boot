package com.cybersoft.springboot.q8;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/q8")
public class Q8Controller {

    private final Q8Service q8Service;

    public Q8Controller(Q8Service q8Service) {
        this.q8Service = q8Service;
    }

    @PostMapping("/documents")
    public ResponseEntity<Q8Response> uploadDocument(@RequestParam("file") MultipartFile file,
                                                     @RequestParam String description, @RequestParam String title,
                                                     @RequestParam String tags) {

        Q8UploadFileDTO uploadFileDTO = new Q8UploadFileDTO();
        uploadFileDTO.setFile(file);
        uploadFileDTO.setDescription(description);
        uploadFileDTO.setTitle(title);
        uploadFileDTO.setTags(tags);

        Q8Response res = q8Service.uploadFile(uploadFileDTO);

        return ResponseEntity.ok(res);
    }
}
