package cn.com.buu.dailyfreshpc.service.uac.impl;

import cn.com.buu.dailyfreshpc.dao.PcUacUserDao;
import cn.com.buu.dailyfreshpc.exception.UacBusinessException;
import cn.com.buu.dailyfreshpc.module.domain.PcUacUser;
import cn.com.buu.dailyfreshpc.module.enums.UacErrorEnum;
import cn.com.buu.dailyfreshpc.module.vo.uac.UacInsertVo;
import cn.com.buu.dailyfreshpc.module.vo.uac.UacLoginVo;
import cn.com.buu.dailyfreshpc.service.uac.UacService;
import cn.com.buu.dailyfreshpc.utils.PubUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Slf4j
@Service
public class UacServiceImpl implements UacService {

    @Resource
    private PcUacUserDao pcUacUserDao;

    @Override
    public PcUacUser login(UacLoginVo uacLoginVo) {

        String userAccount = "";

        // 用户基本信息的校验
        checkUserInfo(uacLoginVo.getLoginType(), userAccount, uacLoginVo);

        // 判断数据库中没有该用户
        PcUacUser userByAccount = pcUacUserDao.findUserByAccount(userAccount);
        if (PubUtils.isNull(userByAccount)) {
            throw new UacBusinessException(UacErrorEnum.UAC_USER_NOT_EXIST);
        }
        return userByAccount;

    }

    @Override
    public PcUacUser insert(UacInsertVo uacInsertVo) {
        return null;
    }


}
