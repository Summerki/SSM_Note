package com.suki.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data  // lombok自动构造set get方法
@NoArgsConstructor  // 自动构造无参构造器
@AllArgsConstructor  // 全部参数构造器
public class Love {
    private Long loveId;
    private String firstName;
    private String lastName;
    private LocalDate birth;
}
