package com.suki.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.suki.dto.ResponseCode;
import com.suki.mapper.LoveMapper;
import com.suki.model.Love;
import com.suki.service.LoveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.image.ReplicateScaleFilter;
import java.util.List;

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
        return loveMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Love love) {
        loveMapper.updateByPrimaryKeySelective(love);
    }

    @Override
    public ResponseCode delete(long id) {
        int row = loveMapper.deleteByPrimaryKey(id);
        ResponseCode code = new ResponseCode();
        if (row == 1) {  // 代表删除成功
            code.setCode(ResponseCode.SUCCESS);
            code.setMsg("删除成功");
        } else {
            code.setCode(ResponseCode.FAIL);
            code.setMsg("删除失败");
        }
        return code;
    }

    @Override
    public PageInfo<Love> query(Integer pageNum, Integer pageSize) {
        // 分页查询
        PageHelper.startPage(pageNum, pageSize);  // 统计出多少数据
        List<Love> loves = loveMapper.selectAll();
        PageInfo<Love> pageInfo = new PageInfo<>(loves);
        return pageInfo;

    }
}
