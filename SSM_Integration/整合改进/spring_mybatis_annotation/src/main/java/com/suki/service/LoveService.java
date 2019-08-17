package com.suki.service;

import com.github.pagehelper.PageInfo;
import com.suki.dto.ResponseCode;
import com.suki.model.Love;

public interface LoveService {
    void save(Love love);

    Love get(long id);

    void update(Love love);

    ResponseCode delete(long id);

    PageInfo<Love> query(Integer pageNum, Integer pageSize);
}
