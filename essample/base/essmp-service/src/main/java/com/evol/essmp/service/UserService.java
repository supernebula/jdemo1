package com.evol.essmp.service;

import com.evol.esdemo.entity.User;
import com.github.pagehelper.Page;

import java.util.List;

public interface UserService {

    /**
     *
     * @param pageIndex 页号
     * @param pageSize  每页记录数
     * @return
     */
    Page<User> queryByPage(int pageIndex, int pageSize);

    /**
     * 获取类别列表
     * @return
     */
    List<User> getUserList();

    /**
     * 通过类别Id获取类别信息
     * @param id
     * @return
     */
    User getUserById(int id);

    /**
     * 增加类别信息
     * @param User
     * @return
     */
    boolean addUser(User User);

    /**
     * 修改类别信息
     * @param User
     * @return
     */
    boolean modifyUser(User User);

    /**
     * 根据Id删除类别
     * @param id
     * @return
     */
    boolean deleteUser(int id);
}
