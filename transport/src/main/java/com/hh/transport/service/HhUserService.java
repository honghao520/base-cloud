package com.hh.transport.service;

import com.hh.transport.entity.HhUser;
public interface HhUserService{


    int deleteByPrimaryKey(Integer id);

    int insert(HhUser record);

    int insertSelective(HhUser record);

    HhUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HhUser record);

    int updateByPrimaryKey(HhUser record);

}
