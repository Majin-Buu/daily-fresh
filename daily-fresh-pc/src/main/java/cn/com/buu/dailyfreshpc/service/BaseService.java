package cn.com.buu.dailyfreshpc.service;

import cn.com.buu.dailyfreshpc.exception.UacBusinessException;
import cn.com.buu.dailyfreshpc.module.enums.UacErrorEnum;
import cn.com.buu.dailyfreshpc.module.vo.uac.UacUserInfo;
import cn.com.buu.dailyfreshpc.utils.PubUtils;
import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;

public interface BaseService {

    // 校验用户基本信息
    default void checkUserInfo(int type, String userAccount, UacUserInfo uacUserInfo) {

        // 判断用户是以为什么方式登录进来的
        switch (type) {

            // 手机号需要验证手机号格式是否符合规则
            case 1:
                Preconditions.checkArgument(!StringUtils.isEmpty(uacUserInfo.getPassword()), "密码不能为空");
                Preconditions.checkArgument(!StringUtils.isEmpty(uacUserInfo.getMobileNo()), "手机号不能为空");
                if (!PubUtils.isMobileNumber(uacUserInfo.getMobileNo())) {
                    throw new UacBusinessException(UacErrorEnum.UAC_MOBILE_ILLEGAL);
                }
                userAccount = uacUserInfo.getMobileNo();
                break;
            case 2:
                Preconditions.checkArgument(!StringUtils.isEmpty(uacUserInfo.getPassword()), "密码不能为空");
                Preconditions.checkArgument(!StringUtils.isEmpty(uacUserInfo.getEmail()), "邮箱不能为空");
                if (!PubUtils.isEmail(uacUserInfo.getEmail())) {
                    throw new UacBusinessException(UacErrorEnum.UAC_MAIL_ILLEGAL);
                }
                userAccount = uacUserInfo.getEmail();
                break;
            case 3:
                Preconditions.checkArgument(!StringUtils.isEmpty(uacUserInfo.getPassword()), "密码不能为空");
                Preconditions.checkArgument(!StringUtils.isEmpty(uacUserInfo.getLoginName()), "用户名不能为空");
                userAccount = uacUserInfo.getLoginName();
                break;
            case 4:
                Preconditions.checkArgument(!StringUtils.isEmpty(uacUserInfo.getVerificationCode()), "验证码不能为空");
                Preconditions.checkArgument(!StringUtils.isEmpty(uacUserInfo.getMobileNo()), "手机号不能为空");
                if (!PubUtils.isEmail(uacUserInfo.getMobileNo())) {
                    throw new UacBusinessException(UacErrorEnum.UAC_MOBILE_ILLEGAL);
                }
                userAccount = uacUserInfo.getMobileNo();
                break;
            case 5:
                Preconditions.checkArgument(!StringUtils.isEmpty(uacUserInfo.getVerificationCode()), "验证码不能为空");
                Preconditions.checkArgument(!StringUtils.isEmpty(uacUserInfo.getEmail()), "邮箱不能为空");
                if (!PubUtils.isEmail(uacUserInfo.getEmail())) {
                    throw new UacBusinessException(UacErrorEnum.UAC_MAIL_ILLEGAL);
                }
                userAccount = uacUserInfo.getEmail();
                break;
        }
    }
}
