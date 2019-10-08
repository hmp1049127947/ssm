package com.wyu160802.dao;

import com.wyu160802.entity.Notice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/4-20:02
 */
@Repository
public interface NoticeDao {

    void addNotice(Notice notice);

    List<Notice> queryNotice();

    Notice showNotice(@Param("id") int id);
}
