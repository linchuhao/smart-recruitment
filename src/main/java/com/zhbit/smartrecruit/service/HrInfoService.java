package com.zhbit.smartrecruit.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zhbit.smartrecruit.data.dto.HrInfo;
import com.zhbit.smartrecruit.data.dto.JobInfo;
import com.zhbit.smartrecruit.data.entity.HrInfoEntity;
import com.zhbit.smartrecruit.data.vo.ResponseMessage;
import org.springframework.web.multipart.MultipartFile;

public interface HrInfoService extends IService<HrInfoEntity> {

    HrInfo getHrInfo(Long userId);

    ResponseMessage updateHrInfo(HrInfo hrInfo);

    ResponseMessage updateJobInfo(JobInfo jobInfo);

    ResponseMessage uploadHrInfoAvatar(MultipartFile avatar, Long userId);

}
