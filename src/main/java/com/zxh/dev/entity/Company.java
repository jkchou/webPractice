package com.zxh.dev.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Data
@Setter
@Getter
@NoArgsConstructor
@ToString
@TableName("company")
public class Company {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer comId;
    private String comName;
    private String sinaWeibo;
    private String tencentWeibo;
    private String url;
    private String contactor;
    private String contactTel;
    private String email;
    private String comPicture;
    private String comHonor;
    private String remark;
    private String creator;
    private String createTime;
    private String modifier;
    private String modifyTime;
    private String officeId;
}
