package com.ching.aitools.controller;

import com.ching.aitools.common.R;
import com.ching.aitools.model.domain.SysMenu;
import com.ching.aitools.model.domain.User;
import com.ching.aitools.model.dto.LoginDto;
import com.ching.aitools.model.entity.RegisterUser;
import com.ching.aitools.model.vo.common.ResultCodeEnum;
import com.ching.aitools.service.SysMenuService;
import com.ching.aitools.service.UserService;
import com.ching.aitools.utils.AuthContextUtil;
import jakarta.annotation.Resource;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    @Resource
    private SysMenuService sysMenuService;

    @PostMapping("/register")
    public R register(@RequestBody RegisterUser user) {
        userService.register(user);
        return R.ok();
    }

    @PostMapping("/login")
    public R login(@RequestBody LoginDto user) {
        String token = userService.login(user);
        return R.ok(token, ResultCodeEnum.SUCCESS);
    }

    @GetMapping("/currentUser")
    public R<User> currentUser(@RequestHeader("Authorization") String token) {
        User user = userService.getUserInfo(token);
        return R.ok(user, ResultCodeEnum.SUCCESS);
    }

    @PostMapping("/outLogin")
    public R outLogin(@RequestHeader("Authorization") String token) {
        userService.logout(token);
        return R.ok();
    }

    @GetMapping("/getRouters")
    public R<List<SysMenu>> getRouters() {
        User user = AuthContextUtil.getUser();
        List<SysMenu> menuRouters = sysMenuService.getMenuRouters(user.getId());
        return R.ok(menuRouters, ResultCodeEnum.SUCCESS);
    }
}
