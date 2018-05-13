package com.system.future.controller;

import com.alibaba.fastjson.JSONObject;
import org.apache.tomcat.util.codec.binary.Base64;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Collections;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigControllerTest {

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void login() {
        final String url = "http://54.254.199.192/api/auth/login";
        final String auth = "{\"auth\":\"semaphore\", \"password\":\"s3m4ph0r3\"}";
        String result = this.restTemplate.postForEntity(url, auth, String.class).getBody();

        System.out.println("Get result : " + result);
    }

    @Test
    public void testGetProjects() {
        final String url = "http://54.254.199.192/api/project/1";
        final String auth = "{\"auth\":\"semaphore\", \"password\":\"s3m4ph0r3\"}";
        final String code = "Basic c2VtYXBob3JlOnM0bTNwaDJyZQ==";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("Authorization", auth);
        JSONObject jsonObj = JSONObject.parseObject(auth);
        HttpEntity<String> formEntity = new HttpEntity<>(jsonObj.toString(), headers);

//        this.restTemplate.setInterceptors(Collections.singletonList(new BasicAuthorizationInterceptor("semaphore", "s3m4ph0r3")));
//        this.restTemplate.postForEntity(url, auth, String.class).getBody();
//        String result = this.restTemplate.getForEntity(url, String.class, formEntity).getBody();
        String result = restTemplate.exchange
                (url, HttpMethod.GET, new HttpEntity(createHeaders("semaphore", "s3m4ph0r3")), String.class).getBody();
        System.out.println("Get result : " + result);
    }

    HttpHeaders createHeaders(String username, String password){
        return new HttpHeaders() {{
            String auth = username + ":" + password;
            byte[] encodedAuth = Base64.encodeBase64(
                    auth.getBytes(Charset.forName("US-ASCII")) );
            String authHeader = "Basic " + new String( encodedAuth );
            set( "Authorization", authHeader );
        }};
    }
}