package com.cybersoft.springboot.q9;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Q9Service {

    private static final List<User> mockData = new ArrayList<>();

    public Q9Service() {
        User user1 = new User();
        user1.setId(1);
        user1.setEmail("ngkhang@gmail.com");
        user1.setName("Nguyen Khang");

        mockData.add(user1);
    }

    public boolean updateUser(int id, Q9UpdateDTO updateDTO) {
        User userExit = getUserById(id);

        if (userExit == null) {
            return false;
        }

        System.out.println("Old email: " + userExit.getEmail());
        userExit.setEmail(updateDTO.getEmail());
        System.out.println("New email: " + userExit.getEmail());

        return true;
    }

    private User getUserById(int id) {
        return mockData.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }
}
