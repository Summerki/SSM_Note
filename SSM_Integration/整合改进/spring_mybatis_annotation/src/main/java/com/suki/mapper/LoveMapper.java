package com.suki.mapper;

import com.suki.model.Love;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * 通过继承BaseMapper<Love>通用mapper
 * 这样对 Love 对象的CURD就自动完成了
 */
public interface LoveMapper extends BaseMapper<Love> {  // 这里按 alt + Enter 可以选择创建mapper xml文件

}
