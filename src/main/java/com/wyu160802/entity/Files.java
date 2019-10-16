package com.wyu160802.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author 黄明潘
 * @date 2019/10/5-16:12
 */
@Data
public class Files implements Serializable {
    private Integer id;
    private String fileName;
    private String fileTitle;
}
