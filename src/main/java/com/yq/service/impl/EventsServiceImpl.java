package com.yq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yq.entity.Actor;
import com.yq.entity.Events;
import com.yq.repository.ActorMapper;
import com.yq.repository.EventsMapper;
import com.yq.service.ActorService;
import com.yq.service.EventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EventsServiceImpl extends ServiceImpl<EventsMapper,Events> implements EventsService {

    @Autowired
    EventsMapper eventsMapper;
    @Autowired
    ActorService actorService;

    @Override
    public Integer getMaxId() {
        return eventsMapper.getMaxId();
    }

    @Override
    public Boolean addEvent(Events event, Long[] time, String users) {
        //插入事件属性
        Integer maxId = getMaxId()+1;
        event.setEno(maxId);
        event.setStartTime(new Date(time[0]));
        event.setEndTime(new Date(time[1]));
        //初始化事件（用于比较事件状态）
        Long now = System.currentTimeMillis();
        Long start = event.getStartTime().getTime();
        Long end = event.getEndTime().getTime();
        //比较日期后插入事件状态
        if(now < start){//事件未开始
            event.setState(0);
        }else if(now > start && now < end){//事件进行中
            event.setState(1);
        }else{//事件未开始
            event.setState(2);
        }
        boolean eventResult = save(event);
        String[] ids = users.split("/");
        List<Actor> list = new ArrayList();
        for(String id:ids){
            list.add(new Actor(maxId,Integer.valueOf(id)));
        }
        list.forEach(i-> System.out.println(i));
        boolean actorResult = actorService.saveBatch(list);
        return eventResult&&actorResult;
    }
}
