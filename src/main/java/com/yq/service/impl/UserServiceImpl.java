package com.yq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yq.entity.EventRecord;
import com.yq.entity.Users;
import com.yq.repository.EventRecordMapper;
import com.yq.repository.EventsMapper;
import com.yq.repository.UsersMapper;
import com.yq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UsersMapper, Users> implements UserService {

    @Autowired
    UsersMapper usersMapper;
    @Autowired
    EventsMapper eventsMapper;
    @Autowired
    EventRecordMapper eventRecordMapper;

    @Override
    public String verify(String account, String password) {
        String realName = usersMapper.verify(account, password);
        if(realName==null){
            return "null";
        }
        return realName;
    }

    @Override
    public Boolean sign_in(Integer eno, String account) {
        Integer uid = usersMapper.queryIdByAccount(account);
        Date date = new Date(System.currentTimeMillis());
        int result = eventRecordMapper.insert(new EventRecord(eno, date, 1, 0, uid));
        return result>0;
    }

    @Override
    public List<EventRecord> record(String account) {
        Integer uid = usersMapper.queryIdByAccount(account);
        List<EventRecord> list = eventRecordMapper.getListByUid(uid);
        return list;
    }
}
