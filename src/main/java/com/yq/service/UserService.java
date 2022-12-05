package com.yq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yq.entity.EventRecord;
import com.yq.entity.Users;

import java.util.List;

public interface UserService extends IService<Users> {

    String verify(String account,String password);

    Boolean sign_in(Integer eno, String account);

    List<EventRecord> record(String account);
}
