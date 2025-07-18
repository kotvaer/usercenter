package org.example.usercenter.controller;

import org.example.usercenter.model.domain.User;
import org.example.usercenter.service.UserService;
import org.example.usercenter.vo.Result;
import org.example.usercenter.vo.UserVO;
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
    public Result<Boolean> userRegister(@RequestBody User user) {
        return userService.save(user);
    }

    /**
     * 查询用户
     * @param id 用户id
     * @return
     */
    @GetMapping("/id")
    public Result<UserVO> searchUserById(Long id) {
        return userService.getById(id);
    }


    @GetMapping("/count")
    public Result<Integer> count(){
        return userService.count();
    }


    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/list")
    public Result<List<UserVO>> listUsers() {
        return userService.list();
    }

    /**
     * 根据用户名查询用户
     * @param name 用户名
     * @return
     */
    @GetMapping("/name")
    public Result<UserVO> searchUserByName(String name) {
        return userService.getByName(name);
    }

    /**
     * 根据用户手机号查询用户
     * @param phone 用户名
     * @return
     */
    @GetMapping("/phone")
    public Result<UserVO> searchUserByPhone(String phone) {
        return userService.getByPhone(phone);
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @PutMapping("/update")
    public Result<Boolean> updateUser(@RequestBody User user) {
        return userService.updateById(user);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public Result<Boolean> deleteUser(Long id) {
        return userService.removeById(id);
    }
}
