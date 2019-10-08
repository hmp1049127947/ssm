package com.wyu160802.service;

import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.Notice;


import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/4-20:10
 */
public interface NoticeService {

    BaseResult addNotice(Notice notice);

    List<Notice> queryNotice();

    Notice showNotice(int id);
}
