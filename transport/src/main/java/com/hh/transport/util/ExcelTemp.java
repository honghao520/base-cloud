package com.hh.transport.util;

import com.alibaba.excel.EasyExcel;
import com.hh.transport.domain.export.TransportExportDTO;
import com.hh.transport.util.excel.ExcelExportAutoWidthStrategy;
import com.hh.transport.util.excel.ExcelUtil;
import com.hh.transport.util.excel.PageDataListener;
import org.aopalliance.intercept.MethodInterceptor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @program: transport
 * @description:
 * @author: hongh
 * @create: 2023-07-06 15:15
 **/
public class ExcelTemp {
    public static void main(String[] args) {
//        aaa(data->{
//            for (TransportExportDTO datum : data) {
//                System.out.println(datum);
//            }
//        }, TransportExportDTO.class);
//

        ExcelUtil.exportExcel("C:\\Users\\Admin\\Desktop\\新的.xlsx", page -> {
            ArrayList<TransportExportDTO> objects = new ArrayList<>();
            TransportExportDTO ne = new TransportExportDTO();
            ne.setTemp("xxxx");
            objects.add(ne);
            return objects;
        },TransportExportDTO.class,new ExcelExportAutoWidthStrategy());
    }

    public static <T> void aaa(Consumer<List<T>> consumer, Class<T> tClass) {
        EasyExcel.read("C:\\Users\\Admin\\Desktop\\吃吃表.xlsx", tClass, new PageDataListener(consumer)).sheet().doRead();
    }
}
