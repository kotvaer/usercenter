package org.example.usercenter.controller;

import org.example.usercenter.model.domain.User;
import org.example.usercenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户接口
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public boolean userRegister(@RequestBody User user) {
        return userService.save(user);
    }

    /**
     * 查询用户
     * @param id
     * @return
     */
    @GetMapping("/id")
    public User searchUserById(Long id) {
        return userService.getById(id);
    }


    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/list")
    public List<User> listUsers() {
        return userService.list();
    }

    /**
     * 根据用户名查询用户
     * @param name 用户名
     * @return
     */
    @GetMapping("/searchByName")
    public User searchUserByName(String name) {
        return userService.getByName(name);
    }
}
