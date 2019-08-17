package com.suki.service.impl;

import com.suki.mapper.LoveMapper;
import com.suki.model.Love;
import com.suki.service.LoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoveServiceImpl implements LoveService {

    @Autowired
    private LoveMapper loveMapper;

    @Override
    public void save(Love love) {
        loveMapper.insert(love);
    }

    @Override
    public Love get(long id) {
        return loveMapper.selectById(id);
    }
}
