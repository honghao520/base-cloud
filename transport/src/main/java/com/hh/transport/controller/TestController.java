package com.hh.transport.controller;

import com.hh.transport.mapper.HhUserMapper;
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

    @GetMapping("/x")
    public String aa(){
        return hhUserMapper.selectByPrimaryKey(1).toString();
    }
}
