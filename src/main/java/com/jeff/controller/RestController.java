package com.jeff.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RestController {

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
    public String getUserById(@PathVariable("id") Integer id){
        System.out.println("GET:id = "+id);
        return "success";
    }

    @RequestMapping(value="/testRest", method=RequestMethod.POST)
    public String insertUser(){
        System.out.println("POST");
        return "success";
    }

    @RequestMapping(value="/testRest", method=RequestMethod.PUT)
    public String updateUser(){
        System.out.println("PUT");
        return "success";
    }

    @RequestMapping(value="/testRest", method=RequestMethod.DELETE)
    public String deleteUser(@PathVariable("id") Integer id){
        System.out.println("DELETE:id = "+id);
        return "success";
    }

    @RequestMapping(value="testAjax_DELETE", method=RequestMethod.DELETE)
    public void testAjax_DELETE(Integer id){
        System.out.println("testAjax_DELETE:id = "+id);
    }
}
