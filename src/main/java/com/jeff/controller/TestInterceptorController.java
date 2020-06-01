package com.jeff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestInterceptorController {

    /**
     * 當有多個攔截器時；
     * preHandle: 按照攔截器數組的正向順序執行
     * postHandle: 按照攔截器數組的反向順序執行
     * afterCompletion: 按照攔截器數組的反向順序執行
     *
     * 當多個攔截器的preHandle有不同的值時
     * 第一個返回false,第二個返回false:只有第一個preHandle會執行
     * 第一個返回true,第二個返回false:兩個攔截器的preHandle都會執行，但是postHandle都不會執行，而agterCompletion只有第一個(返回false的攔截器之前的所有afterCompletion)會執行
     * 第一個返回false,第二個返回true::只有第一個preHandle會執行
     */
    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        return "success";
    }
}
