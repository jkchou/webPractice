package com.zxh.dev.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.*;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("scheduling")
public class Scheduling {
    @TableId(value = "id", type = IdType.AUTO)
    Integer id;
    String name;
    Double plantArea;
    Double foreCast;
    Double realCast;
    Integer officeId;
    Integer plotId;
    Integer greenHouseId;
    String farmProductionsCategoryId;
    String farmProductionsVarietyId;
    String remarks;
    Integer delFlag;
    @TableField(updateStrategy = FieldStrategy.NEVER)
    Timestamp createDate;
    Integer createBy;
    Integer updateBy;
    @TableField(updateStrategy = FieldStrategy.NEVER)
    Timestamp updateDate;
}
