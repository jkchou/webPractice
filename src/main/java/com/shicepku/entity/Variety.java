package com.shicepku.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("variety")
public class Variety {
    @TableId(value = "id", type = IdType.AUTO)
    Integer id;
    String name;
    String category;
    Double ylut;
    Integer plot;
    Integer growthCycle;
    Date plantingIn;
    Date matureIn;
    String picture;
    String remarks;
    Integer delFlag;
}
