package cn.com.buu.dailyfresh.service.uac.impl;

import cn.com.buu.dailyfresh.dao.PcUacUserDao;
import cn.com.buu.dailyfresh.exception.UacBusinessException;
import cn.com.buu.dailyfresh.module.domain.PcUacUser;
import cn.com.buu.dailyfresh.module.enums.UacErrorEnum;
import cn.com.buu.dailyfresh.module.vo.BaseResult;
import cn.com.buu.dailyfresh.module.vo.UacLoginVo;
import cn.com.buu.dailyfresh.service.uac.UacService;
import cn.com.buu.dailyfresh.utils.PubUtils;
import com.google.common.base.Preconditions;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
@Slf4j
public class UacServiceImpl implements UacService {

    @Resource
    private PcUacUserDao pcUacUserDao;

    @Override
    public BaseResult login(UacLoginVo uacLoginVo) {

        // 判断用户是以为什么方式登录进来的
        Preconditions.checkArgument(!StringUtils.isEmpty(uacLoginVo.getLoginPwd()), "密码不能为空");
        String str = NotNullThenReturn(uacLoginVo.getEmail(), uacLoginVo.getLoginName(), uacLoginVo.getMobileNo());

        PcUacUser pcUacUser = pcUacUserDao.selectById(str);

        return BaseResult.ok(pcUacUser);
    }

    private String NotNullThenReturn(Object... args) {
        for (Object object : args) {
            if (!PubUtils.isNull(object)) {
                return String.valueOf(object);
            }
        }
        throw new UacBusinessException(UacErrorEnum.UAC_NULL_PARAM);
    }
}
