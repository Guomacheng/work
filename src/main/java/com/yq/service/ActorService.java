package com.yq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yq.entity.Actor;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ActorService extends IService<Actor> {

    List<String> getUids(Integer eno);
}
