package com.zhbit.smartrecruit.service.Impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhbit.smartrecruit.dao.UserInfooDao;
import com.zhbit.smartrecruit.data.dto.User;
import com.zhbit.smartrecruit.data.dto.UserTest;
import com.zhbit.smartrecruit.data.entity.UserInfooEntity;
import com.zhbit.smartrecruit.service.UserInfooService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserInfooServiceImpl extends ServiceImpl<UserInfooDao, UserInfooEntity> implements UserInfooService {
    /**
     * 查询大于该分数的学生
     * @Author Sans
     * @CreateTime 2019/6/9 14:27
     * @Param  page  分页参数
     * @Param  fraction  分数
     * @Return IPage<UserInfoEntity> 分页数据
     */
    @Override
    public IPage<UserInfooEntity> selectUserInfoByGtFraction(IPage<UserInfooEntity> page, Long fraction) {
        return this.baseMapper.selectUserInfoByGtFraction(page,fraction);
    }

    @Override
    public User findUser(String username){
        return this.baseMapper.selectUserByUsername(username);
    }

    @Override
    public UserTest selectUserTest(String name){
        return this.baseMapper.selectUserTest(name);
    }

    @Override
    public void saveUserTest(UserTest userTest){
        UserInfooEntity userInfooEntity = new UserInfooEntity();
        userInfooEntity.setAge(userTest.getAge());
        userInfooEntity.setName(userTest.getName());
        userInfooEntity.setId(userTest.getId());
        this.baseMapper.insert(userInfooEntity);
    }
}
