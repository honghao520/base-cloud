package com.hh.transport.mapper;

import com.hh.transport.entity.HhUser;


public interface HhUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HhUser record);

    int insertSelective(HhUser record);

    HhUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HhUser record);

    int updateByPrimaryKey(HhUser record);
}
