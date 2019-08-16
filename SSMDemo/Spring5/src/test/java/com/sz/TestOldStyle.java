package com.sz;

import com.sz.service.UserService;
import com.sz.service.impl.ActorServiceImpl;
import com.sz.service.impl.PlayerServiceImpl;
import org.junit.Test;

public class TestOldStyle {

    @Test
    public void m1(){
//        UserService userService = new PlayerServiceImpl();
        // 如果此时想要替换成ActorServiceImpl实现就需要重新写下面这行代码
        // 但是如果是一个大型工程，那么你替换的地方可不止这一处地方，会变得特别繁琐
        UserService userService = new ActorServiceImpl();
        userService.show();
    }
}
