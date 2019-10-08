package com.wyu160802.dao;

import com.wyu160802.entity.User;
import com.wyu160802.entity.UserPageDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/9/23-19:03
 */
@Repository
public interface UserDao {
    User queryUser(@Param("username")String username);

    List<User> queryAllUsers(@Param("leftArg") int leftArg,@Param("rightArg") int rightArg);

    int queryUserTotal();

    void deleteMulti(String[] id);

    User queryUserById(int id);

    void updateUser(User user);

    User queryByNumber(String number);

    User queryByPhone(String phone);

    List<User> searchUser(UserPageDto userPageDto);

    int flitTotal(UserPageDto userPageDto);

    void insertPerson(User user);
}
