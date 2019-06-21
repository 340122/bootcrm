package cn.massz.core.web.controller;

import cn.massz.core.po.User;
import cn.massz.core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * 用户控制器类
 */
@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("/login.action")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/login.action",method = RequestMethod.POST)
    public String login(String usercode, String password, Model model ,HttpSession session){
        //通过账号和密码查询客户
        User user = userService.findUser(usercode, password);
        if (user!=null){
            //将用户对象添加到Session中
            session.setAttribute("USER_SESSION",user);
            //跳转到主页面
            return "redirect:customer/list.action";
        }
        model.addAttribute("msg","账号或密码错误，请重新输入");
        //返回登录页面
        return "login";
    }
    /**
     * 模拟其他类中跳转带到客户管理页面的方法
     */
    @RequestMapping("/toCustomer.action")
    public String toCustomer(){
        return "customer";
    }
    /**
     * 退出登录
     */
    @RequestMapping(value = "/logout.action")
    public String logout(HttpSession session){
        //清除Session
        session.invalidate();
        //重定向到登录页面的跳转方法
        return "redirect:login.action";
    }
    /**
     * 向用户登录页面跳转
     */
    @RequestMapping(value = "/login,action",method = RequestMethod.GET)
    public String toLogin(){
        return "login";
    }

}
