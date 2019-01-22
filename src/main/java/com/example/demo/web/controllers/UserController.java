package com.example.demo.web.controllers;

import com.example.demo.web.modules.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value="/users") //通过这个设置使下面的所有mapping都在 /users 这个路劲之下
public class UserController {
    //创建线程安全的Map
    static Map<Long, User> users = Collections.synchronizedMap(new HashMap<Long, User>());

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getUserList() {
        List<User> returnUsers = new ArrayList<User>(users.values());

        return returnUsers;
    }
}
