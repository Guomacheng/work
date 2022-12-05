package com.yq.controller;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yq.entity.EventRecord;
import com.yq.service.EventRecordService;
import com.yq.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("user")
public class UsersController {
    @Autowired
    UserService userService;
    @Autowired
    EventRecordService eventRecordService;

    @PostMapping("login")
    public String login(String account,String password){
        String realName = userService.verify(account,password);
        return realName;
    }
    @GetMapping("/sign")
    public Boolean sign_in(Integer eno,String account){
        return userService.sign_in(eno,account);
    }
    @GetMapping("/record")
    public List<EventRecord> getRecordList(String account){
        List<EventRecord> list = userService.record(account);
        return list;
    }
}
