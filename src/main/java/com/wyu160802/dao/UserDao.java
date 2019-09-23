package com.wyu160802.dao;

import com.wyu160802.entity.User;
import org.springframework.stereotype.Repository;

/**
 * @author 黄明潘
 * @date 2019/9/23-19:03
 */
@Repository
public interface UserDao {
    User queryUser();
}
