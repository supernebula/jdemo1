package com.essmp.dao.mapper.custom;

import com.essmp.entity.User;
import com.github.pagehelper.Page;

import java.util.List;

public interface CustomUserMapper {
    Page<User> queryByPage();

    /**
     * 列出用户列表
     * @return UserList
     */
    List<User> queryUser();

    /**
     *根据Id获取具体用户
     * @param UserId
     * @return User
     */
    User findUserById(int UserId);

    /**
     * 插入用户信息
     * @param User
     * @return
     */
    int insertUser(User User);

    /**
     * 更新用户信息
     * @param User
     * @return
     */
    int updateUser(User User);

    /**
     * 根据Id删除具体用户
     * @param id
     * @return
     */
    int deleteUser(int id);
}
