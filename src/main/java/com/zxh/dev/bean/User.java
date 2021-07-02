package com.zxh.dev.bean;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

@Data
@NoArgsConstructor
@Setter
@Getter
@ToString
@TableName("users")
public class User {
    private Integer id;
    private String name;
    private Integer age;

}
