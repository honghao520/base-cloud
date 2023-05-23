package com.hh.transport.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hh.transport.mapper.HhUserMapper;
import com.hh.transport.entity.HhUser;

@Service
public class HhUserServiceImpl implements HhUserService{

    @Resource
    private HhUserMapper hhUserMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return hhUserMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(HhUser record) {
        return hhUserMapper.insert(record);
    }

    @Override
    public int insertSelective(HhUser record) {
        return hhUserMapper.insertSelective(record);
    }

    @Override
    public HhUser selectByPrimaryKey(Integer id) {
        return hhUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(HhUser record) {
        return hhUserMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(HhUser record) {
        return hhUserMapper.updateByPrimaryKey(record);
    }

}
