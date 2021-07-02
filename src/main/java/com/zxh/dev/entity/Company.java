package com.zxh.dev.entity;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@Setter
@Getter
@NoArgsConstructor
@ToString
@TableName("company")
public class Company {
    private Integer comId;
    private String comName;
    private String sinaWeibo;
    private String tencentWeibo;
    private String url;
    private String contactor;
    private String contactTel;
    private String email;
    private Byte[] comPicture;
    private Byte[] comHonor;
    private String remark;
    private String creator;
    private String createTime;
    private String modifier;
    private String modifyTime;
    private String officeId;
}
