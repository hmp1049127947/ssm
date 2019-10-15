package com.wyu160802.service.impl;

import com.wyu160802.dao.UserDao;
import com.wyu160802.dto.BaseResult;
import com.wyu160802.entity.User;
import com.wyu160802.entity.UserPageDto;
import com.wyu160802.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 黄明潘
 * @date 2019/9/23-19:11
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


    @Override
    public User queryUser(String number,String password) {
        User user = userDao.queryByNumber(number);
        if (user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    @Override
    public List<User> queryAllUsers(int leftArg,int rightArg) {
        List<User> users = userDao.queryAllUsers(leftArg,rightArg);
        return users;
    }

    @Override
    public int queryUserTotal() {
        return userDao.queryUserTotal();
    }

    @Override
    public void deleteMulti(String[] id) {
        userDao.deleteMulti(id);
    }

    @Override
    public User queryUserById(int id) {
        return userDao.queryUserById(id);
    }

    @Override
    public BaseResult updateUser(User user) {
        BaseResult baseResult = checkUserData(user);
        //数据验证成功
        if (baseResult.status == BaseResult.STATUS_SUCCESS) {
            userDao.updateUser(user);
            baseResult.setMessage("数据修改成功");
            return baseResult;
        } else {
            return baseResult;
        }
    }

    @Override
    public List<User> searchUser(UserPageDto userPageDto) {
        return userDao.searchUser(userPageDto);
    }

    @Override
    public int flitTotal(UserPageDto userPageDto) {
        return userDao.flitTotal(userPageDto);
    }

    @Override
    public BaseResult insertPerson(User user) {
        BaseResult baseResult = checkUserData(user);
        //数据验证成功
        if (baseResult.status == BaseResult.STATUS_SUCCESS) {
            userDao.insertPerson(user);
            baseResult.setMessage("数据插入成功");
            return baseResult;
        } else {
            return baseResult;
        }

    }


    public BaseResult checkUserData(User user) {
        BaseResult baseResult = BaseResult.success();
        if (StringUtils.isBlank(user.getNumber())) {
            baseResult = BaseResult.fail("账号不能为空");
            return baseResult;
        } else {
            //查询数据库中是否存在该账号
            User user1 = userDao.queryByNumber(user.getNumber());
            //如果数据库中存在该账号
            if (user1 != null) {
                //判断是新增还是修改账号
                if (user.getId() != null) {
                    //判断存在的账号是否为自己的账号，如果不是则该账号已被注册
                    if (!user.getId().equals(user1.getId())) {
                        baseResult = BaseResult.fail("该账号已被注册");
                        return baseResult;
                    }
                } else {
                    baseResult = BaseResult.fail("该账号已被注册");
                    return baseResult;
                }
            }
        }

        if (StringUtils.isBlank(user.getPhone())) {
            baseResult = BaseResult.fail("手机号不能为空");
            return baseResult;
        } else {
            User user1 = userDao.queryByPhone(user.getPhone());
            if (user1 != null) {
                if (user.getId() != null) {
                    if (!user.getId().equals(user1.getId())) {
                        baseResult = BaseResult.fail("该手机号已被注册");
                        return baseResult;
                    }
                } else {
                    baseResult = BaseResult.fail("该手机号已被注册");
                    return baseResult;
                }
            }

        }

        if (StringUtils.isBlank(user.getPassword())) {
            baseResult = BaseResult.fail("密码不能为空");
            return baseResult;
        }

        return baseResult;

    }



}
