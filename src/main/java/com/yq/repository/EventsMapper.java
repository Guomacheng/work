package com.yq.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yq.entity.Events;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface EventsMapper extends BaseMapper<Events> {
    @Select("select eno from event_s order by eno desc limit 1")
    Integer getMaxId();

    @Select("select ename from event_s where eno=#{eno}")
    String getEnameByEno(Integer eno);

}
