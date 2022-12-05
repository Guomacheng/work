package com.yq.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yq.entity.Actor;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ActorMapper extends BaseMapper<Actor> {

    @Select("select uid from actor where eno=#{eno}")
    List<String> getUids(Integer eno);

}
