package com.wyu160802.service;

import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.User;
import com.wyu160802.entity.UserPageDto;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/9/23-19:08
 */
public interface UserService {
    User queryUser(String number,String password);

    List<User> queryAllUsers(int leftArg,int rightArg);

    int queryUserTotal();

    void deleteMulti(String[] id);

    User queryUserById(int id);

    BaseResult updateUser(User user);

    List<User> searchUser(UserPageDto userPageDto);

    int flitTotal(UserPageDto userPageDto);

    BaseResult insertPerson(User user);
}
