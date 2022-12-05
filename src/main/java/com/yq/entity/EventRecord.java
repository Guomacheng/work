package com.yq.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("event_record")
public class EventRecord {
    private Integer eno;
    @TableField(exist = false)
    private String ename;
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    private Date date;
    private Integer state;
    private Integer active;
    private Integer uid;

    public EventRecord(Integer eno, Date date, Integer state, Integer active, Integer uid) {
        this.eno = eno;
        this.date = date;
        this.state = state;
        this.active = active;
        this.uid = uid;
    }
}
