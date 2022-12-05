package com.yq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yq.entity.Actor;
import com.yq.repository.ActorMapper;
import com.yq.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl extends ServiceImpl<ActorMapper, Actor> implements ActorService {

    @Autowired
    ActorMapper actorMapper;

    @Override
    public List<String> getUids(Integer eno) {
        return actorMapper.getUids(eno);
    }
}
