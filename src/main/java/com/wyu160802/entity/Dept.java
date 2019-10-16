package com.wyu160802.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 黄明潘
 * @date 2019/10/6-13:18
 */
@Data
public class Dept implements Serializable {

    private Integer id;
    private String name;
    private String remark;

}
