package com.suki.mapper;

import com.suki.model.Love;

public interface LoveMapper {  // 这里按 alt + Enter 可以选择创建mapper xml文件
    void insert(Love love);

    Love selectById(long id);
}
