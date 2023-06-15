package com.hh.transport.service.impl;

import com.hh.transport.domain.dto.TransportDTO;
import com.hh.transport.entity.HhUser;
import com.hh.transport.service.EsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.Query;
import org.springframework.data.elasticsearch.core.query.SourceFilter;
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
        Query query = template.matchAllQuery();
        SearchHits<TransportDTO> search = template.search(query, TransportDTO.class);
        List<SearchHit<TransportDTO>> searchHits = search.getSearchHits();
        for (SearchHit<TransportDTO> searchHit : searchHits) {
            String id = searchHit.getId();
            TransportDTO content = searchHit.getContent();
            System.out.println(id);
        }
        return null;
    }
}
