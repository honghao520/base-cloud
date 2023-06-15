package com.hh.transport.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.util.CharsetUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.hh.transport.entity.HhUser;
import com.hh.transport.service.ItoHttpService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: transport
 * @description:
 * @author: hongh
 * @create: 2023-05-24 10:11
 **/
@Service
@Slf4j
public class ItoHttpServiceImpl implements ItoHttpService {

    @Override
    public void http(){
        List<Object> aa = aa();
        for (Object o : aa) {
            Map<String,Object> map = new HashMap<>();
            map.put("id",o);
            map.put("status","3");


            JSONObject jsonObject = JSONUtil.parseObj(map);
            String s = jsonObject.toString();
            String post = HttpUtil.post("url", s);
            log.info(post);
        }

    }

    public static void main(String[] args) {


        System.out.println(LocalDate.now().getMonth().getValue());
        MultiValueMap<String, Object> map = new LinkedMultiValueMap<>();

        HhUser dto = new HhUser();
        dto.setRemarks("12");
        map.add("syncData", dto);

        //设置请求头
        HttpHeaders headers = new HttpHeaders();

        HttpEntity<MultiValueMap<String, Object>> param = new HttpEntity<>(map, headers);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> stringResponseEntity = null;
            stringResponseEntity = restTemplate.postForEntity("http://192.168.0.46:4523/m1/601809-0-default/storage", param, String.class);
        MultiValueMap<String, Object> body1 = param.getBody();
        System.out.println(JSONUtil.toJsonPrettyStr(body1));
        String body = stringResponseEntity.getBody();

        System.out.println(body);


        String name = "////某某有限公司";
        String trim = StrUtil.trim(CollUtil.get(StrUtil.split(name, StrUtil.SLASH), 4));
        System.out.println(trim);
        LocalDate gspEstimatedDeliveryTime = LocalDate.of(2023,6,14);
        LocalDate localDateTime = LocalDate.of(2023,6,17);
        boolean b = !gspEstimatedDeliveryTime.isAfter(localDateTime.minusDays(7));
        System.out.println(b);
    }

    private  List<Object> aa(){
        String aa ="";
        HttpRequest authorization = HttpRequest.post("url").body(aa).
                header("Authorization", "xxx");
        HttpResponse execute = authorization.execute();
        String body = execute.body();
        JSONObject jsonObject = JSONUtil.parseObj(body);
        Object o = jsonObject.get("data");
        JSONObject jsonObject1 = JSONUtil.parseObj(o);
        Object o1 = jsonObject1.get("items");
        JSONArray objects = JSONUtil.parseArray(o1);

        List<Object> list = new ArrayList<>();
        for (Object object : objects) {
            JSONObject jsonObject2 = JSONUtil.parseObj(object);
            Object o2 = jsonObject2.get("id");
            list.add(o2);
        }
        return list;
    }


}
