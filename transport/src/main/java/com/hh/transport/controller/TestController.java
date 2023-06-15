package com.hh.transport.controller;

import com.hh.transport.mapper.HhUserMapper;
import com.hh.transport.service.EsService;
import com.hh.transport.service.HhUserService;
import com.hh.transport.service.ItoHttpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: transport
 * @description:
 * @author: hongh
 * @create: 2023-05-23 15:53
 **/
@RestController
@RequiredArgsConstructor
public class TestController {

    private final HhUserMapper hhUserMapper;
    private final ItoHttpService httpService;
    private final HhUserService hhUserService;

    private final EsService esService;
    @GetMapping("/x")
    public String aa(){
        return hhUserMapper.selectByPrimaryKey(1).toString();
    }

    @GetMapping("/xxx")
    public String aa21(){
        esService.query();
        return "1";
    }
    @GetMapping("/xx")
    public String aa1(){
        httpService.http();
        return "1";
    }
}
