package com.hh.transport.service.impl;

import com.hh.transport.domain.dto.TransportDTO;
import com.hh.transport.entity.HhUser;
import com.hh.transport.service.EsService;
import com.hh.transport.util.ItemRepository;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: transport
 * @description:
 * @author: hongh
 * @create: 2023-06-15 19:18
 **/
@Service
@Slf4j
public class EsServiceImpl implements EsService {
    @Autowired
    private ElasticsearchRestTemplate template;
    @Autowired
    private ItemRepository itemRepository;
    @Override
    public int saveEs() {

        TransportDTO hhUser = new TransportDTO();
        hhUser.setId(4);
        hhUser.setName("ffff");
        hhUser.setNameZh("fasdasd");
        template.save(hhUser);

        TransportDTO hhUser1 = template.get("4", TransportDTO.class);
        log.info("xx--{}",hhUser1);
        return 0;
    }

    @Override
    public TransportDTO query(){
        NativeSearchQueryBuilder queryBuilder = new NativeSearchQueryBuilder();
        queryBuilder.withQuery(QueryBuilders.termQuery("name", "ffff"));
        queryBuilder.withPageable(PageRequest.of(0,10));
        NativeSearchQuery build = queryBuilder.build();
        SearchHits<TransportDTO> search = template.search(build, TransportDTO.class);
        List<SearchHit<TransportDTO>> searchHits = search.getSearchHits();
        for (SearchHit<TransportDTO> searchHit : searchHits) {
            String id = searchHit.getId();
            System.out.println(searchHit.getContent());
        }
        return null;
    }
}
