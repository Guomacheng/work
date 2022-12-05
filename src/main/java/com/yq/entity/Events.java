package com.yq.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("event_s")
public class Events implements Serializable {
    @TableId
    private Integer eno;
    private String ename;
    @TableField("start_time")
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern = "yyyy/MM/dd",timezone = "GMT+8")
    @TableField("end_time")
    private Date endTime;
    private Integer state;
    @TableField(exist = false)
    private String users;
    private String explains;
}
