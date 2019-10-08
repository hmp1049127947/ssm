package com.wyu160802.service;

import com.wyu160802.entity.Files;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/5-16:19
 */
public interface FilesService {
    void uploadFile(String fileTitle,String fileName);

    List<Files> filesPage(Integer page,Integer rows);

    int filesNum();
}
