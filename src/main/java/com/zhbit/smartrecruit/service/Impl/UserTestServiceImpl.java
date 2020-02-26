package com.zhbit.smartrecruit.service.Impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zhbit.smartrecruit.dao.UserTestDao;
import com.zhbit.smartrecruit.data.dto.User;
import com.zhbit.smartrecruit.data.entity.UserTestEntity;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.service.UserTestService;
import org.springframework.stereotype.Service;

@Service
public class UserTestServiceImpl extends ServiceImpl<UserTestDao, UserTestEntity> implements UserTestService {

     boolean checkUser(User user){

        QueryWrapper<UserTestEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.lambda().eq(UserTestEntity::getUsername,user.getUsername());
        UserTestEntity userTestEntity = this.baseMapper.selectOne(queryWrapper);
        if (userTestEntity == null){
            return false;
        }
        System.out.println("用户已存在");
        return true;
    }

    @Override
    public ResponseMessage regist(User user){
        ResponseMessage responseMessage;
        if (!checkUser(user)){
            UserTestEntity userTestEntity = new UserTestEntity();
            userTestEntity.setUsername(user.getUsername());
            userTestEntity.setPassword(user.getPassword());
            userTestEntity.setEmail(user.getEmail());
            userTestEntity.setPhone(user.getPhone());
            this.baseMapper.insert(userTestEntity);
            System.out.println(userTestEntity.getUserId());
            responseMessage = ResponseMessage.successMessage(user);
            return responseMessage;
        }
        responseMessage = ResponseMessage.failedMessage("用户已存在");
        return responseMessage;
    }
}
