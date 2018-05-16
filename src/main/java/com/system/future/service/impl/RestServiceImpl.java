package com.system.future.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.system.future.domain.Demoable;
import com.system.future.service.RestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
@PropertySource("classpath:rest.properties")
@Slf4j
public class RestServiceImpl implements RestService {
    private static HttpHeaders headers = new HttpHeaders();

    static {
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
    }

    @Value("${baseUrl}")
    private String baseUrl;

    @Value("${auth_code}")
    private String authCode;

    @Autowired
    private RestTemplate restTemplate;

    private void setHeadersWithAuth() {
        headers.add("authorization", authCode);
    }

    private String request(final String url, final HttpMethod method) {
        return request(url, method, null);
    }

    private String request(final String url, final HttpMethod method, JSONObject jsonObject) {
        if(!headers.containsKey("authorization")) {
            setHeadersWithAuth();
        }
        final HttpEntity<JSONObject> formEntity = new HttpEntity<>(jsonObject, headers);
        String result = restTemplate.exchange
                (url, method, formEntity, String.class).getBody();
        log.info("Get response from request:" + result);
        return result;
    }


    @Override
    public List<Demoable> findAll() {
        String result = request(baseUrl + "projects", HttpMethod.GET);
        List<Demoable> list = JSON.parseObject(result, new TypeReference<ArrayList<Demoable>>() {});
        return list;
    }
}
