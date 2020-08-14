package com.bruceliu.controller;

import com.bruceliu.utils.ResultMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.UUID;

/**
 * @Auther: bruceliu
 * @Date: 2019/12/11 10:01
 * @QQ:1241488705
 * @Description: 负责项目中的文件上传
 */
@Controller
public class UploadController {

    /**
     * 文件上传步骤：
     *  1.导入文件上传所需要的依赖
     */
    @ResponseBody
    @RequestMapping("/photoUpload")
    public ResultMessage upload(@RequestParam("file") MultipartFile f, HttpSession session) throws Exception{
        String odlFileName=f.getOriginalFilename();
        System.out.println("要上传的原始文件名字:"+odlFileName);  // 234234324.jpeg
        //截取原始的文件名的后缀
        String[] strings = odlFileName.split("\\.");
        //包装一下文件名
        String fileName = UUID.randomUUID().toString()+"."+ strings[strings.length-1];
        System.out.println("服务器包装之后的文件名:"+fileName);

        //获取文件上传的真实的文件服务器路径
        String realPath = session.getServletContext().getRealPath("/media/upload");
        realPath=realPath+"\\"+fileName;
        System.out.println("真实的要上传的服务器地址:"+realPath);
        //实现文件上传
        f.transferTo(new File(realPath));
        System.out.println("文件上传成功~~~~");

        ResultMessage resultMessage=new ResultMessage(200,fileName);
        return resultMessage;
    }
}
