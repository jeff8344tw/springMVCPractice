package com.jeff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mvc")
public class TestController {

    /**
     * @RequestMapping:設置請求映射，把請求和控制層中的方法設置映射關系
     * @RequestMapping可以加載在方法上，也可以加在方法上
     * 若類和方法上都加，應該一層一層的訪問，先訪問類，在訪問類中的方法
     * 當請求路徑和@RequestMapping的value屬性值一致時，則該註解所註釋的方法即為處理
     * method:用來設置請求方式，只有庫戶端發送請求的方式和method的值一致，才能處理請求
     * 請求方式:GET查詢 POST添加 PUT修改 DELETE刪除
     * params:用來設置客戶端傳到服務端的數據，支持表達式
     * headers:用來設置請求頭訊息，所發送的請求頭訊息一定要和headers屬性中所設置的一致
     */
    @RequestMapping(value = "/test",
            method = RequestMethod.GET,
            params = {"username"}
//          ,headers = {}
            )
    public String testGET() {
        System.out.println("SUCCESS:GET");
        return "success";
    }

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String testPOST() {
        System.out.println("SUCCESS:POST");
        return "success";
    }

    /**
     * springMVC支持Ant方式的請求路徑
     * 在Ant中，有3個匹配符
     * *:任意字符
     * ?:任意一個字符
     * **:任意多層目錄
     */
    @RequestMapping(value = "/*/ant??/**/testAnt")
    public String testAnt() {
        System.out.println("SUCCESS:testAnt");
        return "success";
    }

    /**
     * 以前:localhost:8080/spirgMVCPractice/mvc/testRest?id=1001&username=admin
     * 現在:localhost:8080/spirgMVCPractice/mvc/testRest?1001&admin
     */
    @RequestMapping("testREST/{id}/{username}")
    public String testREST(@PathVariable("id") Integer id, @PathVariable("username") String userName){
        System.out.println("id = "+id+" username = "+userName);
        return "success";
    }
}
