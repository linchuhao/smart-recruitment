package com.zhbit.smartrecruit.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zhbit.smartrecruit.data.dto.UserTest;
import com.zhbit.smartrecruit.data.entity.UserInfooEntity;
import com.zhbit.smartrecruit.service.UserInfooService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
@RequestMapping("/userInfo")
public class UserInfooController {
    @Autowired
    private UserInfooService userInfooService;
    /**
     * 根据ID获取用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:34
     * @Param  userId  用户ID
     * @Return UserInfoEntity 用户实体
     */
    @ApiOperation("根据ID获取用户信息")
    @PostMapping("/getInfo")
    public UserInfooEntity getInfo(@RequestBody String userId){
        UserInfooEntity userInfooEntity = userInfooService.getById(userId);
        return userInfooEntity;
    }
    /**
     * 查询全部信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:35
     * @Param  userId  用户ID
     * @Return List<UserInfoEntity> 用户实体集合
     */
    @ApiOperation("查询全部信息")
    @PostMapping("/getList")
    public List<UserInfooEntity> getList(){
        List<UserInfooEntity> userInfooEntityList = userInfooService.list();
        return userInfooEntityList;
    }
    /**
     * 分页查询全部数据
     * @Author Sans
     * @CreateTime 2019/6/8 16:37
     * @Return IPage<UserInfoEntity> 分页数据
     */
    @ApiOperation("分页查询全部数据")
    @PostMapping("/getInfoListPage")
    public IPage<UserInfooEntity> getInfoListPage(){
        //需要在Config配置类中配置分页插件
        IPage<UserInfooEntity> page = new Page<>();
        page.setCurrent(5); //当前页
        page.setSize(1);    //每页条数
        page = userInfooService.page(page);
        return page;
    }
    /**
     * 根据指定字段查询用户信息集合
     * @Author Sans
     * @CreateTime 2019/6/8 16:39
     * @Return Collection<UserInfoEntity> 用户实体集合
     */
    @ApiOperation("根据指定字段查询用户信息集合")
    @PostMapping("/getListMap")
    public Collection<UserInfooEntity> getListMap(){
        Map<String,Object> map = new HashMap<>();
        //kay是字段名 value是字段值
        map.put("age",20);
        Collection<UserInfooEntity> userInfooEntityList = userInfooService.listByMap(map);
        return userInfooEntityList;
    }
    /**
     * 新增用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:40
     */
    @ApiOperation("新增用户信息")
    @PostMapping("/saveInfo")
    public void saveInfo(@RequestBody UserInfooEntity userInfooEntity){
/*        UserInfoEntity userInfoEntity = new UserInfoEntity();
        userInfoEntity.setName("小龙");
        userInfoEntity.setSkill("JAVA");
        userInfoEntity.setAge(18);
        userInfoEntity.setFraction(59L);
        userInfoEntity.setEvaluate("该学生是一个在改BUG的码农");*/
        userInfooService.save(userInfooEntity);
    }
    /**
     * 批量新增用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:42
     */
    @ApiOperation("批量新增用户信息")
    @PostMapping("/saveInfoList")
    public void saveInfoList(){
        //创建对象
        UserInfooEntity sans = new UserInfooEntity();
        sans.setName("Sans");
        sans.setSkill("睡觉");
        sans.setAge(18);
        sans.setFraction(60L);
        sans.setEvaluate("Sans是一个爱睡觉,并且身材较矮骨骼巨大的骷髅小胖子");
        UserInfooEntity papyrus = new UserInfooEntity();
        papyrus.setName("papyrus");
        papyrus.setSkill("JAVA");
        papyrus.setAge(18);
        papyrus.setFraction(58L);
        papyrus.setEvaluate("Papyrus是一个讲话大声、个性张扬的骷髅，给人自信、有魅力的骷髅小瘦子");
        //批量保存
        List<UserInfooEntity> list =new ArrayList<>();
        list.add(sans);
        list.add(papyrus);
        userInfooService.saveBatch(list);
    }
    /**
     * 更新用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:47
     */
/*    @ApiOperation("更新用户信息")*/
    @PostMapping("/updateInfo")
    public void updateInfo(){
        //根据实体中的ID去更新,其他字段如果值为null则不会更新该字段,参考yml配置文件
        UserInfooEntity userInfooEntity = new UserInfooEntity();
        userInfooEntity.setId(1L);
        userInfooEntity.setAge(19);
        userInfooService.updateById(userInfooEntity);
    }
    /**
     * 新增或者更新用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:50
     */
/*    @ApiOperation("新增或者更新用户信息")*/
    @PostMapping("/saveOrUpdateInfo")
    public void saveOrUpdate(){
        //传入的实体类userInfoEntity中ID为null就会新增(ID自增)
        //实体类ID值存在,如果数据库存在ID就会更新,如果不存在就会新增
        UserInfooEntity userInfooEntity = new UserInfooEntity();
        userInfooEntity.setId(1L);
        userInfooEntity.setAge(20);
        userInfooService.saveOrUpdate(userInfooEntity);
    }
    /**
     * 根据ID删除用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:52
     */
/*    @ApiOperation("根据ID删除用户信息")*/
    @PostMapping("/deleteInfo")
    public void deleteInfo(String userId){
        userInfooService.removeById(userId);
    }
    /**
     * 根据ID批量删除用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:55
     */
/*    @ApiOperation("根据ID批量删除用户信息")*/
    @PostMapping("/deleteInfoList")
    public void deleteInfoList(){
        List<String> userIdlist = new ArrayList<>();
        userIdlist.add("12");
        userIdlist.add("13");
        userInfooService.removeByIds(userIdlist);
    }
    /**
     * 根据指定字段删除用户信息
     * @Author Sans
     * @CreateTime 2019/6/8 16:57
     */
/*    @ApiOperation("根据指定字段删除用户信息")*/
    @PostMapping("/deleteInfoMap")
    public void deleteInfoMap(){
        //kay是字段名 value是字段值
        Map<String,Object> map = new HashMap<>();
        map.put("skill","删除");
        map.put("fraction",10L);
        userInfooService.removeByMap(map);
    }
    /**
     * MP自定义SQL
     * @Author Sans
     * @CreateTime 2019/6/9 14:37
     * @Return IPage<UserInfoEntity> 分页数据
     */
    @PostMapping("/getInfoListSQL")
    @ApiOperation("查询大于60分以上的学生,并且分页")
    public IPage<UserInfooEntity> getInfoListSQL(){
        //查询大于60分以上的学生,并且分页
        IPage<UserInfooEntity> page = new Page<>();
        page.setCurrent(1);
        page.setSize(5);
        page = userInfooService.selectUserInfoByGtFraction(page,60L);
        return page;
    }

    @PostMapping("/test")
    @ApiOperation("测试")
    public UserTest testUser(@RequestBody UserTest userTest){
        UserTest u = new UserTest();
        u = userInfooService.selectUserTest(userTest.getName());
        return u;
    }

    @PostMapping("/testsave")
    @ApiOperation("测试save")
    public void testUserSave(@RequestBody UserTest userTest){
        UserTest e = new UserTest();
        userInfooService.saveUserTest(userTest);
    }
}

