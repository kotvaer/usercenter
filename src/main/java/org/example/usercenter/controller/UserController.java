package org.example.usercenter.controller;

import org.example.usercenter.model.domain.User;
import org.example.usercenter.service.UserService;
import org.example.usercenter.vo.Result;
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
        boolean saved = userService.save(user);
        return Result.success(saved);
    }

    /**
     * 查询用户
     * @param id 用户id
     * @return
     */
    @GetMapping("/id")
    public Result<User> searchUserById(Long id) {
        User user = userService.getById(id);
        return Result.success(user);
    }


    @GetMapping("/count")
    public Result<Integer> count(){
        return Result.success(userService.count());
    }


    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/list")
    public Result<List<User>> listUsers() {
        List<User> list = userService.list();
        return Result.success(list);
    }

    /**
     * 根据用户名查询用户
     * @param name 用户名
     * @return
     */
    @GetMapping("/name")
    public Result<User> searchUserByName(String name) {
        User user = userService.getByName(name);
        return Result.success(user);
    }

    /**
     * 根据用户手机号查询用户
     * @param phone 用户名
     * @return
     */
    @GetMapping("/phone")
    public Result<User> searchUserByPhone(String phone) {
        User user = userService.getByPhone(phone);
        return Result.success(user);
    }

    /**
     * 更新用户
     * @param user
     * @return
     */
    @PutMapping("/update")
    public Result<Boolean> updateUser(@RequestBody User user) {
        boolean updated = userService.updateById(user);
        return Result.success(updated);
    }

    /**
     * 删除用户
     * @param id
     * @return
     */
    @DeleteMapping("/delete")
    public Result<Boolean> deleteUser(Long id) {
        boolean removed = userService.removeById(id);
        return Result.success(removed);
    }
}
