package com.wyu160802.entity;

import lombok.Data;

import java.io.Serializable;
import lombok.Data;

/**
 * @author 黄明潘
 * @date 2019/10/6-16:37
 */
@Data
public class Job implements Serializable {

    private int id;
    private String name;
    private String remark;
}
