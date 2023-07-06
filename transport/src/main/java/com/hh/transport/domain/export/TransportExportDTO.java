package com.hh.transport.domain.export;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @program: transport
 * @description: 导入数据
 * @author: hongh
 * @create: 2023-07-06 15:30
 **/
@Data
public class TransportExportDTO {


    @ExcelProperty("xx")
    private String temp;
}
