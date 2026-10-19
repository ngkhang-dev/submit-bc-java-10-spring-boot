package com.cybersoft.springboot.q5;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class Q5Service {

    public List<String> getListTags(String tags) {
        return Arrays.stream(tags.split(",")).toList();
    }
}
