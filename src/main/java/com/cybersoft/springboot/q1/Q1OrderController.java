package com.cybersoft.springboot.q1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/q1/orders")
public class Q1OrderController {

    private final Q1OrderService orderService;

    public Q1OrderController(Q1OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{orderId}")
    public ResponseEntity<Q1ResponseDTO> getOrderById(@PathVariable String orderId, @RequestParam String currency) {
        int orderIdNumber = Integer.parseInt(orderId);

        Q1ResponseDTO res = orderService.getOrderById(orderIdNumber, currency);

        return ResponseEntity.ok().body(res);
    }
}
