package com.hh.transport.domain.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @program: transport
 * @description:
 * @author: hongh
 * @create: 2023-06-15 19:29
 **/
@Data
@Document(indexName = "xxx")
public class TransportDTO {

    @Id
    private Integer id;
    @Field(type = FieldType.Text)
    private String name;
    @Field(type = FieldType.Keyword)
    private String nameZh;
}
