package com.cybersoft.springboot.q2;

import org.springframework.stereotype.Service;

@Service
public class Q2Service {

    public String createComment(int postId, Q2CreateDTO createDTO) {

        return "Comment created successfully. PostID=" + postId + " - Content: " + createDTO.getContent();
    }
}
