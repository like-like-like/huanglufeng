package com.bruceliu.controller;

import com.bruceliu.pojo.Depart;
import com.bruceliu.service.DepartService;
import com.bruceliu.utils.PageUtils;
import com.bruceliu.utils.ResultMessage;
import com.sun.corba.se.impl.protocol.giopmsgheaders.RequestMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Auther: bruceliu
 * @Date: 2019/12/10 10:54
 * @QQ:1241488705
 * @Description:
 */
@Controller
public class DeptController {

    @Autowired
    DepartService departService;

    /**
     * 查询所有的部门下拉框
     * @return
     */
    @ResponseBody
    @RequestMapping("/deaprt_findDeparts")
    public List<Depart> findDeparts() {
        return departService.findDeparts();
    }

    @ResponseBody
    @RequestMapping("/deaprt_delete")
    public ResultMessage deaprt_delete(int id){
        ResultMessage requestMessage = null;
        int count=departService.deleteDepart(id);
        if (count > 0) {
            requestMessage = new ResultMessage(200, "部门删除成功");
        } else {
            requestMessage = new ResultMessage(500, "部门删除失败");
        }
        return  requestMessage;
    }

    /**
     * 01-分页
     * /depart_list/1/5
     * @return
     */
    @RequestMapping("/depart_list/{pageIndex}/{pageSize}")
    public String depart_list(@PathVariable("pageIndex") long pageIndex, @PathVariable("pageSize") long pageSize, Model model){
        int totalCount = departService.getTotalCount(); //总条数
        List<Depart> departs = departService.getDeparts((pageIndex - 1) * pageSize, pageSize);//每页数据
        //封装一个分页的工具类
        PageUtils pageUtils=new PageUtils(pageIndex,pageSize,totalCount,departs);
        model.addAttribute("pageUtils",pageUtils);
        return "departlist";
    }

    @ResponseBody
    @RequestMapping("/depart_add")
    public ResultMessage depart_add(Depart depart) {
        ResultMessage requestMessage = null;
        System.out.println("要新增的对象:" + depart);
        int count = departService.addDepart(depart);
        if (count > 0) {
            requestMessage = new ResultMessage(200, "部门添加成功");
        } else {
            requestMessage = new ResultMessage(500, "部门添加失败");
        }
        return  requestMessage;
    }

}
