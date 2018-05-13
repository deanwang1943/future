package com.system.future.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest")
public class ConfigController {

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
    public void addProject() {

    }

    public void getProject(){

    }

    /**
     * key type sshkey, private key
     * /api/project/{id}/keys
     * {
     "name": "string",
     "type": "ssh",
     "project_id": 0,
     "key": "string",
     "secret": "string"
     }
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
     "id": 0,
     "name": "string",
     "project_id": 0,
     "inventory": "string",
     "key_id": 0,
     "ssh_key_id": 0,
     "type": "static"
     }
     */
    public void addProjectInve() {

    }

    /**
     * playbook name, target sshkey, inve id, playbook repo, alias
     * /api/project/{id}/templates
     * {
     "id": 0,
     "ssh_key_id": 0,
     "project_id": 0,
     "inventory_id": 0,
     "repository_id": 0,
     "environment_id": 0,
     "alias": "string",
     "playbook": "string",
     "arguments": "string",
     "override_args": true
     }
     */
    public void addProjectTemp(){

    }
}
