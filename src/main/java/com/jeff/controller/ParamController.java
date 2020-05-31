package com.jeff.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class ParamController {

    /**
     * 在springMVC獲取客戶端傳遞數據的方式:
     * 1.在處理請求的方法中，加入相對應的形參，保證形參參數名和傳遞的數據參數名保持一致，就可以自動賦值
     * @RequestParam:
     * value: 當不滿足賦值條件時，可以使用value屬性，指定映射關係
     * required: 設置形參數是否必須被賦值，默認為true，必須賦值，若設置為false，則不必賦值，因此形參的值為null
     * defaultValue: 若形參所獲得的值為null，則設置一個默認值，用在分業和模糊查詢中。
     */
//    @RequestMapping(value="/param", method= RequestMethod.POST)
//    public String param(@RequestParam(value = "name", required = false, defaultValue = "admin") String username, String password, String age){
//        System.out.println("username = "+username+",password = "+password+",age = "+age);
//        System.out.println("");
//        return "success";
//    }

    /**
     * @RequestHeader: 在處理請求的方法上，獲取請求頭訊息，用法和@RequestParam一致
     */
//    @RequestMapping(value="/param", method= RequestMethod.POST)
//    public String param(@RequestHeader("Accept-Language") String AcceptLanguage){
//        System.out.println("AcceptLanguage=  "+AcceptLanguage);
//        return "success";
//    }

    /**
     * @CookieValue: 在處理請求的方法上，獲取cookie訊息，用法和@RequestParam一致
     */
//    @RequestMapping(value="/param", method= RequestMethod.POST)
//    public String param(@CookieValue(value="JESSIONID") String JSESSIONID){
//        System.out.println("JSESSIONID=  "+JSESSIONID);
//        return "success";
//    }

    /**
     * 可以使用POJO獲取客戶端數據，要求實體類對象中的屬性名一定要和頁面中表單元素的name屬性值一致，且支持集聯關係
     * 可以通過設置形參的方式，獲取serveltAPI
     */
//    @RequestMapping(value="/param", method= RequestMethod.POST)
//    public String param(User user, HttpServletRequest request, HttpServletResponse response){
//        String username = request.getParameter("username");
//        System.out.println("username = "+username);
//        return "success";
//    }

    /**
     * springMVC處理請求過程中，往作用域中放值有以下三種方式
     * 總結: 根據ModelAndView源碼調適，不管使用以下哪種方式，最終都會把model數據和view數據封裝到一個ModelAndView對象中
     */
//    @RequestMapping(value="/param", method= RequestMethod.POST)
//    public ModelAndView param(){
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("username","root"); // 往request作用域放值
//        mav.setViewName("success"); // 設置視圖名稱，實現頁面跳轉
//        return mav;
//    }

//    @RequestMapping(value="/param", method= RequestMethod.POST)
//    public String param(Map<String, Object> map){
//        map.put("username","admin");
//        return "success";
//    }

    @RequestMapping(value="/param", method= RequestMethod.POST)
    public String param(Model model){
        model.addAttribute("username","root");
        return "success";
    }
}
