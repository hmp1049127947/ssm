package com.wyu160802.dao;

import com.wyu160802.entity.Files;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/5-16:18
 */
@Repository
public interface FilesDao {
    void uploadFile(@Param("fileTitle") String fileTitle, @Param("fileName") String fileName);

    List<Files> filesPage(@Param("page") int page,@Param("rows") int rows);

    int filesNum();
}
