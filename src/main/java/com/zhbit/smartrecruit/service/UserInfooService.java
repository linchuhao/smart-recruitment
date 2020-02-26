package com.zhbit.smartrecruit.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.zhbit.smartrecruit.data.dto.User;
import com.zhbit.smartrecruit.data.dto.UserTest;
import com.zhbit.smartrecruit.data.entity.UserInfooEntity;

public interface UserInfooService extends IService<UserInfooEntity> {
    /**
     * 查询大于该分数的学生
     * @Author Sans
     * @CreateTime 2019/6/9 14:27
     * @Param  page  分页参数
     * @Param  fraction  分数
     * @Return IPage<UserInfoEntity> 分页数据
     */
    IPage<UserInfooEntity> selectUserInfoByGtFraction(IPage<UserInfooEntity> page, Long fraction);

    User findUser(String username);

    UserTest selectUserTest(String name);

    void saveUserTest(UserTest userTest);
}