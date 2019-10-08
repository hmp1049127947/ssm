package com.wyu160802.service.impl;

import com.wyu160802.dao.FilesDao;
import com.wyu160802.entity.Files;
import com.wyu160802.service.FilesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/5-16:20
 */
@Service
public class FilesServiceImpl implements FilesService {

    @Autowired
    private FilesDao filesDao;

    @Override
    public void uploadFile(String fileTitle,String fileName) {
        filesDao.uploadFile(fileTitle,fileName);
    }

    @Override
    public List<Files> filesPage(Integer page,Integer rows) {
        return filesDao.filesPage(page,rows);
    }

    @Override
    public int filesNum() {
        return filesDao.filesNum();
    }
}
