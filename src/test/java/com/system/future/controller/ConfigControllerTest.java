package com.system.future.controller;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConfigControllerTest {

    @Autowired
    ConfigController configController;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    public void testGetProject() {
        final String url = "http://54.254.199.192/api/projects";
        final Map<String, String> params = new HashMap<>();
        HttpHeaders headers = new HttpHeaders();
        headers.add("authorization", "bearer ea26cdr_ftazqk2au2fknbn9r1_zq07id38wfdmfudu=");
        params.put("authorization", "bearer ea26cdr_ftazqk2au2fknbn9r1_zq07id38wfdmfudu=");
        restTemplate.getForEntity(url, String.class, new HttpEntity<String>(headers)).getBody();
    }

    @Test
    public void testGetProjects() {
        final String url = "http://54.254.199.192/api/projects";
        final String code = "bearer ea26cdr_ftazqk2au2fknbn9r1_zq07id38wfdmfudu=";
        HttpHeaders headers = new HttpHeaders();
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("authorization", code);
        HttpEntity<String> formEntity = new HttpEntity<>(null, headers);

//        this.restTemplate.postForEntity(url, auth, String.class).getBody();
//        String result = restTemplate.getForEntity(url, String.class, formEntity).getBody();
        String result = restTemplate.exchange
                (url, HttpMethod.GET, formEntity, String.class).getBody();
        System.out.println("Get result : " + result);
    }

    @Test
    public void addProject() {
        configController.addProject("test34");
    }


    @Autowired
    private WebApplicationContext context;
    private MockMvc mvc;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.webAppContextSetup(context).build();//建议使用这种
    }

    @Test
    public void testGetProjectsM() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/rest/projects")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testJobRun() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/rest/project/1/tasks/run")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testJobStatus() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/rest/project/1/tasks")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print())
                .andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("success")));
    }
}