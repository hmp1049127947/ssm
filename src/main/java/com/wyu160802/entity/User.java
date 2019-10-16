package com.wyu160802.entity;



import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 黄明潘
 * @date 2019/9/23-19:04
 */
@Data
public class User implements Serializable {

    private Integer id;
    private String number;
    private String password;
    private Integer status;
    private String phone;
    @JSONField(format = "yyyy-MM/dd HH:mm:ss")
    private Date createdate;
    private String username;
    private String remark;

}
