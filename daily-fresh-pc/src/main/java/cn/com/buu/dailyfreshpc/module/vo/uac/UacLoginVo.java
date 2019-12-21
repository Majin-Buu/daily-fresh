package cn.com.buu.dailyfreshpc.module.vo.uac;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class UacLoginVo extends UacUserInfo implements Serializable {

    private static final long serialVersionUID = -4186862110204825130L;

    @ApiModelProperty(name = "loginType", value = "登录方式 1: 手机号+密码 ,2: 邮箱+密码 ,3: 用户名+密码 ,4: 手机号+验证码 ,5: 邮箱+验证码 ")
    private Integer loginType;

}
