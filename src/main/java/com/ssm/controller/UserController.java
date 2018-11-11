package com.ssm.controller;

import com.ssm.model.User;
import com.ssm.service.UserService;
import org.apache.commons.io.FileUtils;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.html.FormSubmitEvent;
import java.io.File;
import java.util.Map;


@Controller
@RequestMapping("/user")
public class UserController {
    private static Logger logger= LoggerFactory.getLogger(UserController.class);
    @Resource
    private UserService userService;
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(HttpServletRequest request, Model model){
            int userId=Integer.parseInt(request.getParameter("id"));
            System.out.println(userId);
            User user=null;
            user = userService.getUserById(userId);
            System.out.println(user);
            model.addAttribute("user",user);
            return "index";

    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public @ResponseBody User testJson(@PathVariable String id, Map<String,Object> model){
        int userId = Integer.parseInt(id);
        System.out.println("userId:"+userId);
        User user = this.userService.getUserById(userId);
        logger.info(user.toString());
        return user;
    }
    @RequestMapping(value = "json/{id}",method = RequestMethod.GET)
    public ResponseEntity<User> testJson2(@PathVariable String id,Map<String, Object> model){
        int userId = Integer.parseInt(id);
        System.out.println("userId:"+userId);
        User user = this.userService.getUserById(userId);
        logger.info(user.toString());
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping("/showUpload")
    public String showUploadPage(){
        return "upload";
    }
    @RequestMapping(value = "/doUpload",method = RequestMethod.POST)
    public String doUpload(@RequestParam("file")MultipartFile file) throws Exception{
        if(!file.isEmpty()){
            System.out.println(file.getOriginalFilename());
        }
        FileUtils.copyInputStreamToFile(file.getInputStream(),new File("D:\\",System.currentTimeMillis()+file.getOriginalFilename()));
        return "success";
    }
}
