package com.bruceliu.controller;

import com.bruceliu.pojo.Emp;
import com.bruceliu.pojo.Loginlog;
import com.bruceliu.service.EmpService;
import com.bruceliu.service.LoginlogService;
import com.bruceliu.utils.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Auther: bruceliu
 * @Date: 2019/12/9 11:06
 * @QQ:1241488705
 * @Description:
 */
@Controller
public class EmpController {

    @Autowired
    EmpService empService;

    @Autowired
    LoginlogService loginlogService;

    @ResponseBody
    @RequestMapping("/emp_add")
    public ResultMessage addEmp(Emp emp){
        ResultMessage requestMessage = null;
        int count = empService.addEmp(emp);
        if (count > 0) {
            requestMessage = new ResultMessage(200, "员工添加成功");
        } else {
            requestMessage = new ResultMessage(500, "员工添加失败");
        }
        return  requestMessage;
    }

    @RequestMapping("/emp_login")
    @ResponseBody//将返回值自动转化为JSON
    public ResultMessage login(Emp emp,String ip,String cityAndAddress, HttpServletResponse response, HttpSession session) throws Exception {
        System.out.println("ip："+ip);
        System.out.println("cityAndAddress："+cityAndAddress);
        ResultMessage message = null;
        response.setContentType("text/html;charset=utf-8");
        System.out.println("要登录的对象是:" + emp);
        Emp loginEmp = empService.login(emp);
        if (loginEmp != null) {
            if (loginEmp.getFlag() == 1) {
                //登录成功去重定向首页
                //response.sendRedirect("index.jsp");
                //存session
                session.setAttribute("loginEmp",loginEmp);
                //存储用户登录的日志信息
                Loginlog loginlog=new Loginlog(ip,emp.getNo(),cityAndAddress);
                int count = loginlogService.addLoginLog(loginlog);
                System.out.println(count>0?"日志新增成功":"日志新增失败");
                message = new ResultMessage(200, "登录成功");
            } else {
                //response.getWriter().write("<script>alert('账号已经被禁用，请联系管理员!');location.href='login.jsp';</script>");
                message = new ResultMessage(300, "账号已经被禁用，请联系管理员!");
            }
        } else {
            //response.getWriter().write("<script>alert('账号或密码错误!');location.href='login.jsp';</script>");
            message = new ResultMessage(500, "账号或密码错误!");
        }
        //把message对象使用工具，转为JSON字符串，不用人工拼接
        return message;
    }

    @ResponseBody //返回值转JSON
    @RequestMapping("/getLoginlogs")
    public List<Loginlog> getLoginlogs(HttpSession session){
        return loginlogService.getLastestLog(((Emp)session.getAttribute("loginEmp")).getNo());
    }
}
