package com.yq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yq.entity.EventRecord;
import com.yq.repository.EventRecordMapper;
import com.yq.service.EventRecordService;
import org.springframework.stereotype.Service;

@Service
public class EventRecordServiceImpl extends ServiceImpl<EventRecordMapper, EventRecord> implements EventRecordService {

}
