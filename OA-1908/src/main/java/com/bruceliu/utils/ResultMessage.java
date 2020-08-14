package com.bruceliu.utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Auther: bruceliu
 * @Date: 2019/12/9 14:29
 * @QQ:1241488705
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultMessage {

    private int status; //状态码
    private String message; //信息

}
