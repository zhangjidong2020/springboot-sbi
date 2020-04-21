package com.hp.controller;

import com.hp.pojo.User;
import com.hp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.constraints.Email;
import java.util.List;

@Controller
@RequestMapping
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("user/{id}")//{id} 占位符
    @ResponseBody
    public User queryUserById(@PathVariable("id") Long userId){

        User user=userService.queryUserById(userId);
        if(null!=user){
            return user;

        }
        return null;

    }

    @GetMapping("/delete/{i}")
    @ResponseBody
    public String deleteById(@PathVariable("i") Long userId){
        userService.deleteById(userId);
        return "success";
    }

    @GetMapping("user/list")
    public String getUserList(Model model){

       List<User> list= userService.queryAll();
        model.addAttribute("users",list);
        //request.setAttribute("users",list);
       return "users";//视图名称

    }
}
