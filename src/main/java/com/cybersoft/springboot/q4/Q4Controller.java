package com.cybersoft.springboot.q4;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/q4/search")
public class Q4Controller {

    @GetMapping
    public ResponseEntity<Q4ResponseDTO> search(@RequestParam String keyword,
                                                @RequestParam(defaultValue = "0") String page,
                                                @RequestParam(defaultValue = "10") String size) {
        int pageNumber = Integer.parseInt(page);
        int pageSize = Integer.parseInt(size);

        Q4ResponseDTO res = new Q4ResponseDTO();
        res.setKeyword(keyword);
        res.setPage(pageNumber);
        res.setSize(pageSize);

        return ResponseEntity.ok().body(res);
    }
}
