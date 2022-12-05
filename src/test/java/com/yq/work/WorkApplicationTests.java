package com.yq.work;

import com.yq.entity.Events;
import com.yq.entity.Users;
import com.yq.service.EventsService;
import com.yq.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class WorkApplicationTests {

    @Autowired
    EventsService eventsService;

    @Autowired
    UserService userService;
    @Test
    void contextLoads() {
        Integer maxId = eventsService.getMaxId();
        System.out.println(maxId);
        String s = userService.verify("admin", "admins");
        System.out.println(s);
        Events events = eventsService.getById(1);
        System.out.println(events);
    }

}
