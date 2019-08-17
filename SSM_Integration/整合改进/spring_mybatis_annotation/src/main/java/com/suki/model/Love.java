package com.suki.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data  // lombok自动构造set get方法
@NoArgsConstructor  // 自动构造无参构造器
@AllArgsConstructor  // 全部参数构造器
public class Love {
    // 添加主键策略
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long loveId;
    private String firstName;
    private String lastName;
    private Date birth;
}
