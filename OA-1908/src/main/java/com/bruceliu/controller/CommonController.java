package com.bruceliu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: bruceliu
 * @Date: 2019/12/9 14:57
 * @QQ:1241488705
 * @Description: 通用的控制器
 */
@Controller
public class CommonController {

    /***
     * 通用的页面跳转方法
     *  /page_index
     *  /page_clock
     *
     * @param page
     * @return
     */
    @RequestMapping("/page_{XXX}")
    public String toPage(@PathVariable("XXX") String page){
        return page;  //  前缀 + page + 后缀  【配置视图解析器】
    }

}
