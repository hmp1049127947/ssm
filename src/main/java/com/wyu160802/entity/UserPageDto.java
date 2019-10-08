package com.wyu160802.entity;

/**
 * @author 黄明潘
 * @date 2019/10/4-1:38
 */
public class UserPageDto {

    private String username;
    private String phone;
    private String number;
    private Integer pageNumber;
    private Integer rows;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "UserPageDto{" +
                "username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", number='" + number + '\'' +
                ", pageNumber=" + pageNumber +
                ", rows=" + rows +
                '}';
    }
}
