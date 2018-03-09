package org.demo.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
public class TestController {

    @RequestMapping(value = "/welcome")
    public String welcome() {
        return "welcome";
    }

    @RequestMapping(value = "/index")
    public String index(Model model) {
        model.addAttribute("message","这是一个测试");
        List<String> list = new ArrayList<String>();
        for (int i=0; i<5; i++) {
            list.add("测试测试："+i);
        }
        model.addAttribute("list", list);
        return "index";
    }

    /**
     * WebSocket广播界面
     * @return
     */
    @RequestMapping(value = "/broadcast")
    public String broadcast() {
        return "broadcast";
    }

    /**
     * WebSocket私聊界面
     * @return
     */
    @RequestMapping(value = "/chat")
    public String chat() {
        return "chat";
    }

}
