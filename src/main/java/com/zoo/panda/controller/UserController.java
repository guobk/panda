package com.zoo.panda.controller;

import com.zoo.panda.entity.User;
import com.zoo.panda.result.Result;
import com.zoo.panda.service.UserService;
import com.zoo.panda.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.HtmlUtils;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping(value = "/panda")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping(value="/user/login",method = RequestMethod.POST)
  public Result login(@RequestBody User requestUser, HttpSession session) {
    // 对 html 标签进行转义，防止 XSS 攻击
    String username = HtmlUtils.htmlEscape(requestUser.getUserName());

    User user = userService.getByUsernameAndPassword(username,requestUser.getPassWord());
    if(StringUtils.isNullOrEmpty(user)){
      return new Result(400);
    }else{
      session.setAttribute("user", user);
      return new Result(200);
    }
//    if (!Objects.equals("admin", username) || !Objects.equals("123456", requestUser.getPassWord())) {
//      String message = "账号密码错误";
//      System.out.println("test");
//      return new Result(400);
//    } else {
//      return new Result(200);
//    }
  }
}
