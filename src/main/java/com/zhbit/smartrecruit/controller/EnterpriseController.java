package com.zhbit.smartrecruit.controller;

import com.zhbit.smartrecruit.data.vo.EnterpriseVo;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import com.zhbit.smartrecruit.service.EnterpriseService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/enterprise")
public class EnterpriseController {

    @Resource
    EnterpriseService enterpriseService;

    @GetMapping("/getAllEnterprise")
    @ApiOperation("获取所有企业信息")
    public List<EnterpriseVo> getAllEnterprise() {
        return enterpriseService.getAllEnterprise();
    }

    @GetMapping("/getHotEnterprise")
    @ApiOperation("获取热门企业信息")
    public ResponseMessage getHotEnterprise() {
        return ResponseMessage.successMessage(enterpriseService.getHotEnterprise());
    }

}
