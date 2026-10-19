package com.cybersoft.springboot.q8;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class Q8Service {

    public Q8Response uploadFile(Q8UploadFileDTO uploadFileDTO) {
        List<String> tagsList = Arrays.asList(uploadFileDTO.getTags().split(","));

        Q8Response res = new Q8Response();
        res.setTags(tagsList);
        res.setTitle(uploadFileDTO.getTitle());
        res.setOriginalFilename(uploadFileDTO.getFile().getOriginalFilename());
        res.setDescription(uploadFileDTO.getDescription());

        return res;
    }
}
