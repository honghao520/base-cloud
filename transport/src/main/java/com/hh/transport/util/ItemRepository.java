package com.hh.transport.util;

import com.hh.transport.entity.HhUser;
import org.elasticsearch.action.get.MultiGetRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @program: transport
 * @description:
 * @author: hongh
 * @create: 2023-06-14 20:23
 **/
@Repository
public interface ItemRepository extends ElasticsearchRepository<HhUser,Integer> {
    // 当前接口继承ElasticsearchRepository父接口后
    // 会自动在类中生成基本的增删改查方法,直接可以使用
    // 它自动识别或自动生成的规则,是我们定义的两个泛型ElasticsearchRepository<[实体类名],[主键类型]>


}
