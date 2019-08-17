package com.suki.service;

import com.suki.model.Love;

public interface LoveService {
    void save(Love love);

    Love get(long id);
}
