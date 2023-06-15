package com.hh.transport.service.impl;

import cn.hutool.log.Log;
import com.hh.transport.service.HhUserService;
import com.hh.transport.util.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.hh.transport.mapper.HhUserMapper;
import com.hh.transport.entity.HhUser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
@Slf4j
public class HhUserServiceImpl implements HhUserService  {
    @Autowired
    private ItemRepository itemRepository;
    @Resource
    private HhUserMapper hhUserMapper;
    @Autowired
    private ElasticsearchRestTemplate template;
    @Override
    public int deleteByPrimaryKey(Integer id) {

        HhUser hhUser = new HhUser();
        hhUser.setId(2);
        hhUser.setName("ffff");
        template.save(hhUser);

        HhUser hhUser1 = template.get("2", HhUser.class);
        log.info("xx--{}",hhUser1);
        return 0;
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
