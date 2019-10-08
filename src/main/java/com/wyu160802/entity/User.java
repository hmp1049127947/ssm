package com.wyu160802.entity;



import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 黄明潘
 * @date 2019/9/23-19:04
 */
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", status=" + status +
                ", phone='" + phone + '\'' +
                ", createdate=" + createdate +
                ", username='" + username + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
