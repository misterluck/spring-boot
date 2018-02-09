package org.demo.springboot.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class TestRestController {

    @RequestMapping(value = "/hello")
    public String hello() {
        return "Hello World!";
    }

    @RequestMapping(value = "/info/{name}")
    public Map<String, String> info(@PathVariable(value = "name") String username) {
        Map<String, String> map = new HashMap<String, String>();
        map.put("username", username);
        return map;
    }

    @RequestMapping(value = "/list")
    public List<Map<String, String>> list() {
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();
        Map<String, String> map = null;
        for (int i=0; i<5; i++) {
            map = new HashMap<String, String>();
            map.put("name", "name"+i);
            list.add(map);
        }
        return list;
    }

}
