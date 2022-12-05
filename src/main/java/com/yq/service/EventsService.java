package com.yq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yq.entity.Events;

public interface EventsService extends IService<Events> {

    Integer getMaxId();

    Boolean addEvent(Events event, Long[] time, String users);
}
