package com.hh.transport.util.excel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.write.builder.ExcelWriterBuilder;
import com.alibaba.excel.write.handler.WriteHandler;
import com.alibaba.excel.write.metadata.WriteSheet;
import org.apache.commons.collections4.CollectionUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @program: transport
 * @description:
 * @author: hongh
 * @create: 2023-07-06 15:48
 **/
public class ExcelUtil {

    public static <T> void importExcel(File file,Consumer<List<T>> consumer, Class<T> tClass) {
        EasyExcel.read(file, tClass, new PageDataListener(consumer)).sheet().doRead();
    }

    public static <T> void importExcel(String filePath,Consumer<List<T>> consumer, Class<T> tClass) {
        EasyExcel.read(filePath, tClass, new PageDataListener(consumer)).sheet().doRead();
    }

    public static <T> void importExcelAsync(File file,Consumer<List<T>> consumer, Class<T> tClass) {
        CompletableFuture.runAsync(()->{
            EasyExcel.read(file, tClass, new PageDataListener(consumer)).sheet().doRead();
        });
    }
    public static <T> void importExcel(File file,Consumer<List<T>> consumer, Class<T> tClass,Runnable afterDo) {
        CompletableFuture.runAsync(()->{
            EasyExcel.read(file, tClass, new PageDataListener(consumer)).sheet().doRead();
        }).whenComplete(((unused, throwable) -> {
            afterDo.run();
        }));
    }

    /**
     * 分页导出
     * @param filePath
     * @param function
     * @param tClass
     * @param writeHandlers
     * @param <T>
     */
    public static <T> void exportExcel(String filePath, Function<Integer,List<T>> function, Class<T> tClass, WriteHandler... writeHandlers) {
        WriteSheet writeSheet = EasyExcel.writerSheet("sheet").build();
        ExcelWriterBuilder write = EasyExcel.write(filePath, tClass);
        for (WriteHandler writeHandler : writeHandlers) {
            write.registerWriteHandler(writeHandler);
        }
        try (ExcelWriter build = write.build()) {
            int page = 1;
            List<T> data = new ArrayList<>();
            do {
                List<T> apply = function.apply(page);
                data.addAll(apply);
                build.write(data, writeSheet);
                page++;
                data.clear();
            } while (CollectionUtils.isNotEmpty(data));
        }
    }

    public static <T> void exportExcel(File file, Function<Integer,List<T>> function, Class<T> tClass, WriteHandler... writeHandlers) {
        WriteSheet writeSheet = EasyExcel.writerSheet("sheet").build();
        ExcelWriterBuilder write = EasyExcel.write(file, tClass);
        for (WriteHandler writeHandler : writeHandlers) {
            write.registerWriteHandler(writeHandler);
        }
        try (ExcelWriter build = write.build()) {
            int page = 1;
            List<T> data = new ArrayList<>();
            do {
                List<T> apply = function.apply(page);
                data.addAll(apply);
                build.write(data, writeSheet);
                page++;
                data.clear();
            } while (CollectionUtils.isNotEmpty(data));
        }
    }
    public static <T> void exportExcel(String filePath, List<T> list, Class<T> tClass, WriteHandler... writeHandlers) {
        exportExcel(filePath, page->{return list;}, tClass, writeHandlers);
    }

    public static <T> void exportExcel(File file, List<T> list, Class<T> tClass, WriteHandler... writeHandlers) {
        exportExcel(file, page->{return list;}, tClass, writeHandlers);
    }

}
