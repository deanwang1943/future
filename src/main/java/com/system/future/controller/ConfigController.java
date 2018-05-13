package com.system.future.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import jdk.nashorn.internal.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/rest")
public class ConfigController {

    private final static String BASE_URL = "http://54.254.199.192/api/";
    private final static String AUTH_CODE = "bearer ea26cdr_ftazqk2au2fknbn9r1_zq07id38wfdmfudu=";
    private static HttpHeaders headers = new HttpHeaders();

    static {
        MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
        headers.setContentType(type);
        headers.add("Accept", MediaType.APPLICATION_JSON.toString());
        headers.add("authorization", AUTH_CODE);
    }

    @Autowired
    private RestTemplate restTemplate;

    public void login() {
        final String url = "";
        final String auth = "";
        String result = this.restTemplate.postForEntity(url, auth, String.class).getBody();

        System.out.println("Get result : " + result);
    }

    /**
     * project name
     * /api/projects
     * name:
     * alert:true
     */
    @PostMapping("/projects")
    public void addProject(@RequestBody String name) {
        Map<String, Object> params = new HashMap<>();
        params.put("name", name);
        params.put("alert", true);
        JSONObject itemJSONObj = JSONObject.parseObject(JSON.toJSONString(params));
        final HttpEntity<JSONObject> formEntity = new HttpEntity<>(itemJSONObj, headers);
        String result = projectHandler(HttpMethod.POST, formEntity);
        System.out.println("Get all projects:" + result);
    }

    /**
     *
     */
    @GetMapping("/projects")
    public void getProjects() {
        final HttpEntity<String> formEntity = new HttpEntity<>(null, headers);
        String result = projectHandler(HttpMethod.GET, formEntity);
        System.out.println("Get all projects:" + result);

    }

    private String projectHandler(HttpMethod method, HttpEntity formEntity) {
        final String url = BASE_URL + "projects";
        String result = restTemplate.exchange
                (url, method, formEntity, String.class).getBody();
        System.out.println("Get all projects:" + result);
        return result;
    }

    /**
     * key type sshkey, private key
     * /api/project/{id}/keys
     * {
     * "name": "string",
     * "type": "ssh",
     * "project_id": 0,
     * "key": "string",
     * "secret": "string"
     * }
     */
    public void addProjectKeys() {

    }

    /**
     *
     */
    public void addProjectRepo() {

    }

    /**
     * set [host] ip ansible_ssh_user=centos target sshkey
     * /api/project/{id}/inventory
     * {
     * "id": 0,
     * "name": "string",
     * "project_id": 0,
     * "inventory": "string",
     * "key_id": 0,
     * "ssh_key_id": 0,
     * "type": "static"
     * }
     */
    public void addProjectInve() {

    }

    /**
     * playbook name, target sshkey, inve id, playbook repo, alias
     * /api/project/{id}/templates
     * {
     * "id": 0,
     * "ssh_key_id": 0,
     * "project_id": 0,
     * "inventory_id": 0,
     * "repository_id": 0,
     * "environment_id": 0,
     * "alias": "string",
     * "playbook": "string",
     * "arguments": "string",
     * "override_args": true
     * }
     */
    public void addProjectTemp() {

    }
}
