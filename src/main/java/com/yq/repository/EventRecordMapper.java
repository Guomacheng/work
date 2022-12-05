package com.yq.repository;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yq.entity.EventRecord;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventRecordMapper extends BaseMapper<EventRecord> {

    @Select("select * from event_record where uid=#{uid}")
    @Results(id = "getEvent",value= {
            @Result(property = "eno", column = "eno"),
            @Result(property = "ename", column = "eno", javaType = String.class,
                    one = @One(select = "com.yq.repository.EventsMapper.getEnameByEno"))
    })
    List<EventRecord> getListByUid(Integer uid);
}
