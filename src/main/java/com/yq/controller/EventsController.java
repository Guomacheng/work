package com.yq.controller;

import com.yq.entity.Events;
import com.yq.repository.ActorMapper;
import com.yq.service.ActorService;
import com.yq.service.EventsService;
import org.apache.ibatis.annotations.Many;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
import java.util.List;

@RestController
public class EventsController {

    @Autowired
    EventsService eventsService;
    @Autowired
    ActorService actorService;


    @GetMapping("list")
    public List<Events> getEvents(){
        return eventsService.list();
    }

    @PostMapping("addEvent")
    public Boolean addEvent(Events event, Long[] time, String users){
        Boolean result = eventsService.addEvent(event,time,users);
        return result;
    }

    @GetMapping("getById")
    public Events getEventById(Integer eno){
        Events event = eventsService.getById(eno);
        List<String> uids = actorService.getUids(eno);
        String users = "";
        for (int i = 0; i <uids.size(); i++) {
            users = users+uids.get(i);
            if(i==uids.size()-1){
                break;
            }else{
                users+=",";
            }
        }
        event.setUsers(users);
        return event;
    }
}
