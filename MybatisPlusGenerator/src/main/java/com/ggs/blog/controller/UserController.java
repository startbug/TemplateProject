package com.ggs.blog.controller;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ggs.blog.entity.User;
import com.ggs.blog.service.UserService;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author Starbug
 * @since 2020-07-25
 */
@RestController
@RequestMapping("/blog/user")
public class UserController {

    @Autowired
    private UserService userService;

    //http://localhost:8080/blog/user/insert
    @PostMapping("/insert")
    public boolean insertUser(@RequestBody User user) {
        boolean save = userService.save(user);
        System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
        return save;
    }

    //http://localhost:8080/blog/user/list
    @RequestMapping("/list")
    public List<User> findAllList() {
        BaseMapper<User> baseMapper = userService.getBaseMapper();
        List<User> userList = userService.list();
        List<User> users = baseMapper.selectList(null);
        users.forEach(user -> {
            System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
        });
        System.out.println("-----------------------------------------------------");
        System.out.println("-----------------------------------------------------");
        userList.forEach(user -> {
            System.out.println(ReflectionToStringBuilder.toString(user, ToStringStyle.MULTI_LINE_STYLE));
        });
        return userList;
    }

    @PostMapping("/update")
    public boolean updateUser(@RequestBody User user) {
        //乐观锁的使用
        //先查询出该条数据的version
        User userInDB = userService.getById(user.getId());
        //将旧的version添加到前端传来的user对象中, 然后直接修改, mybatis-plus会根据version查询,并为version+1
        user.setVersion(userInDB.getVersion());
        return userService.updateById(user);
    }


    @PostMapping("/delete")
    public boolean deleteUser(Long id) {
        return userService.removeById(id);
    }

    @GetMapping("/get/by/{id}")
    public User getById(@PathVariable Long id){
        return userService.getById(id);
    }
}

