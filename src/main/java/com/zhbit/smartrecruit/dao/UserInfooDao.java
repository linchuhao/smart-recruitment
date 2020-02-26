package com.zhbit.smartrecruit.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.zhbit.smartrecruit.data.dto.User;
import com.zhbit.smartrecruit.data.dto.UserTest;
import com.zhbit.smartrecruit.data.entity.UserInfooEntity;

public interface UserInfooDao extends BaseMapper<UserInfooEntity> {
    /**
     * 查询大于该分数的学生
     * @Author Sans
     * @CreateTime 2019/6/9 14:28
     * @Param  page  分页参数
     * @Param  fraction  分数
     * @Return IPage<UserInfoEntity> 分页数据
     */
    IPage<UserInfooEntity> selectUserInfoByGtFraction(IPage<UserInfooEntity> page, Long fraction);

    User selectUserByUsername(String username);

    UserTest selectUserTest(String name);

}