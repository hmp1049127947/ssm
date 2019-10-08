package com.wyu160802.service.impl;

import com.wyu160802.dao.NoticeDao;
import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.Notice;
import com.wyu160802.service.NoticeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/10/4-20:11
 */
@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeDao noticeDao;

    @Override
    public BaseResult addNotice(Notice notice) {
        BaseResult baseResult = checkNoticeData(notice);
        if (baseResult.status == BaseResult.STATUS_SUCCESS) {
            noticeDao.addNotice(notice);
            baseResult.setMessage("公告保存成功");
            return baseResult;
        } else {
            return baseResult;
        }
    }

    @Override
    public List<Notice> queryNotice() {
        return noticeDao.queryNotice();
    }

    @Override
    public Notice showNotice(int id) {
        return noticeDao.showNotice(id);
    }

    public BaseResult checkNoticeData(Notice notice) {
        BaseResult baseResult = BaseResult.success();
        if (StringUtils.isBlank(notice.getName())) {
            baseResult = BaseResult.fail("公告名称不能为空");
        } else if (StringUtils.isBlank(notice.getTitle())) {
            baseResult = BaseResult.fail("公告标题不能为空");
        } else if (StringUtils.isBlank(notice.getContent())) {
            baseResult = BaseResult.fail("公告内容不能为空");
        }
        return baseResult;
    }
}
