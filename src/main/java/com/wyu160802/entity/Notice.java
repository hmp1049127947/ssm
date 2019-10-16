package com.wyu160802.entity;

import lombok.Data;

import java.io.Serializable;


/**
 * @author 黄明潘
 * @date 2019/10/4-20:08
 */
@Data
public class Notice implements Serializable {

    private Integer id;
    private String name;
    private String title;
    private String content;

}
