package com.cybersoft.springboot.q1;

import org.springframework.stereotype.Service;

@Service
public class Q1OrderService {

    public Q1ResponseDTO getOrderById(int orderId, String currency) {
        Q1ResponseDTO res = new Q1ResponseDTO();

        res.setOrderId(orderId);
        res.setCurrency(currency);

        return res;
    }
}
