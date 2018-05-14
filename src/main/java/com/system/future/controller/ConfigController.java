package com.system.future.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.system.future.vo.InventoryVO;
import com.system.future.vo.KeyVO;
import com.system.future.vo.RepositoriesVO;
import com.system.future.vo.TemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/rest")
@PropertySource("classpath:rest.properties")
@Slf4j
public class ConfigController {
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
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(params));
        String result = request(baseUrl + "projects", HttpMethod.POST, jsonObject);
        log.info("Add project:" + result);
    }

    /**
     *
     */
    @GetMapping("/projects")
    public void getProjects() {
        String result = request(baseUrl + "projects", HttpMethod.GET);
        log.info("Get all projects:" + result);
    }

    private String request(final String url, final HttpMethod method) {
        return request(url, method, null);
    }

    private String request(final String url, final HttpMethod method, JSONObject jsonObject) {
        setHeadersWithAuth();
        final HttpEntity<JSONObject> formEntity = new HttpEntity<>(jsonObject, headers);
        String result = restTemplate.exchange
                (url, method, formEntity, String.class).getBody();
        log.info("Get response from request:" + result);
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
    @PostMapping("/project/{projectId}/keys")
    public void addProjectKeys(@PathVariable("projectId") Long projectId,@RequestBody KeyVO vo) {
        final String url = baseUrl + "project/" + projectId + "/keys";
        Map<String, Object> params = new HashMap<>();
        params.put("name", vo.getName());
        params.put("type", "ssh");
        params.put("project_id", projectId);
        params.put("key", vo.getKey());
        params.put("secret", vo.getSecret());
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(params));
        String result = request(url, HttpMethod.POST, jsonObject);
    }

    /**
     * {
     * "name": "string",
     * "project_id": 0,
     * "git_url": "string",
     * "ssh_key_id": 0
     * }
     */
    @PostMapping("/project/{projectId}/repositories")
    public void addProjectRepo(@PathVariable("projectId") Long projectId, @RequestBody RepositoriesVO vo) {
        final String url = baseUrl + "project/" + projectId + "/repositories";
        Map<String, Object> params = new HashMap<>();
        params.put("name", vo.getName());
        params.put("git_url", vo.getGitUrl());
        params.put("project_id", projectId);
        params.put("ssh_key_id", vo.getSshKeyId());
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(params));
        String result = request(url, HttpMethod.POST, jsonObject);
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
    @PostMapping("/project/{projectId}/inventory")
    public void addProjectInve(@PathVariable("projectId") Long projectId,@RequestBody InventoryVO vo) {
        final String url = baseUrl + "project/" + projectId + "/inventory";
        Map<String, Object> params = new HashMap<>();
        params.put("name", vo.getName());
        params.put("inventory", vo.getInventory());
        params.put("project_id", projectId);
        params.put("key_id", vo.getKeyId());
        params.put("ssh_key_id", vo.getSshKeyId());
        params.put("type", "static");
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(params));
        String result = request(url, HttpMethod.POST, jsonObject);
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
    @PostMapping("/project/{projectId}/templates")
    public void addProjectTemp(@PathVariable("projectId") Long projectId,@RequestBody TemplateVO vo) {
        final String url = baseUrl + "project/" + projectId + "/templates";
        Map<String, Object> params = new HashMap<>();
        params.put("inventory_id", vo.getInventoryId());
        params.put("project_id", projectId);
        params.put("repository_id", vo.getRepositoryId());
        params.put("ssh_key_id", vo.getSshKeyId());
        params.put("environment_id", vo.getEnvironmentId());
        params.put("alias", vo.getAlias());
        params.put("playbook", vo.getPlaybook());
        params.put("arguments", vo.getArguments());
        params.put("override_args", true);
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(params));
        String result = request(url, HttpMethod.POST, jsonObject);
    }

    /**
     * project_id
     * {
     * "template_id": 0,
     * "debug": true,
     * "dry_run": true,
     * "playbook": "string",
     * "environment": "string"
     * }
     */
    @PostMapping("/project/{projectId}/tasks")
    public void startJobs(@PathVariable("projectId") Long projectId) {
        final String url = baseUrl + "project/" + projectId + "/tasks";
        String result = request(url, HttpMethod.GET);
        log.info(result);
        JSONObject jsonObject = JSONObject.parseObject(JSON.toJSONString(result));
        result = request(url, HttpMethod.POST, jsonObject);
    }
}
