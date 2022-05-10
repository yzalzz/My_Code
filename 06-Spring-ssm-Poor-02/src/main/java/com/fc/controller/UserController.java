package com.fc.controller;

import com.fc.entity.User;
import com.fc.service.UserService;
import com.fc.vo.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
@CrossOrigin("*")
@Api(tags = "用户管理", description = "用户相关的所有操作")
public class UserController {
    //controller层调用service层
    @Autowired
    private UserService userService;
    @ApiOperation(value = "查询用户", notes = "分页查询，模糊查询，根据id查询")
    @GetMapping("getlist")
    public ResultVo list(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, @RequestParam(value = "pageSize", defaultValue = "3") Integer pageSize, User param) {
        return userService.list(pageNum, pageSize, param);
    }

    @ApiOperation("删除用户")
    @GetMapping("delete")
    public ResultVo del(Long id) {
        return userService.del(id);
    }
    @ApiOperation("修改用户")
    @PostMapping("update")
    public ResultVo update(@RequestBody User user) {
        return userService.updata(user);
    }
    @ApiOperation("添加用户")
    @PostMapping("add")
    public ResultVo add(@RequestBody User user) {
        return userService.add(user);
    }
    @ApiOperation("用户登录")
    @PostMapping("login")
    public ResultVo login(@RequestParam String username,
                          @RequestParam String password) {
        return userService.login(username, password);
    }

}

