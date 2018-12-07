package com.evol.esdemo.service.Impl;

import com.evol.esdemo.dao.mapper.custom.CustomUserMapper;
import com.evol.esdemo.entity.User;
import com.evol.esdemo.service.UserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Autowired
    private CustomUserMapper customUserMapper;

    @Override
    public Page<User> queryByPage(int pageIndex, int pageSize) {
        PageHelper.startPage(pageIndex, pageSize);
        return customUserMapper.queryByPage();
    }

    @Override
    public List<User> getUserList() {
        return customUserMapper.queryUser();
    }

    @Override
    public User getUserById(int UserId) {
        /*if(1 == 1)
            throw new RuntimeException(this.getClass().getName() + ":故意抛出的异常！！");*/
        return customUserMapper.findUserById(UserId);
    }


    //并不是所有的异常都会回滚，默认值接收RuntimeException才回滚;
    // 可以通过rollbackFor 指定类型的异常回滚,如下：
    //@Transactional(rollbackFor = Exception.class
    @Transactional
    @Override
    public boolean addUser(User User) {
        if(User == null
                || User.getUsername() == null
                || "" == User.getUsername().trim()){
            throw new RuntimeException("类别信息不能为空！");
        }
        User.setCreateTime(new Date());
        User.setLastLoginTime(new Date());
        try {
            int effectedNum = customUserMapper.insertUser(User);
            if(effectedNum == 0)
                throw new RuntimeException("插入类别信息失败！");
            return true;
        }catch (Exception ex){
            throw  new RuntimeException("插入类别信息失败：" + ex.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean modifyUser(User User) {
        if(User == null
                || User.getUsername() == null
                || "" == User.getUsername().trim()){
            throw new RuntimeException("类别信息不能为空！");
        }
        User.setLastLoginTime(new Date());
        try {
            int effectedNum = customUserMapper.updateUser(User);
            if(effectedNum == 0)
                throw new RuntimeException("修改类别信息失败！");
            return true;
        }catch (Exception ex){
            throw  new RuntimeException("修改类别信息失败：" + ex.getMessage());
        }
    }

    @Override
    @Transactional
    public boolean deleteUser(int UserId) {
        if(UserId <= 0)
            throw  new RuntimeException("区域Id不能为空！");
        try {
            int effectedNum = customUserMapper.deleteUser(UserId);
            if(effectedNum == 0)
                throw new RuntimeException("删除类别信息失败:");
            return true;
        }catch (Exception ex){
            throw new RuntimeException("删除类别信息失败:" + ex.getMessage());
        }
    }
}
