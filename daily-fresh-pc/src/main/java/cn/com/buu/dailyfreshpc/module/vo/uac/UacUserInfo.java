package cn.com.buu.dailyfreshpc.module.vo.uac;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class UacUserInfo {

    @ApiModelProperty(name = "mobileNo", value = "手机号")
    private String mobileNo;

    @ApiModelProperty(name = "password", value = "登录密码")
    private String password;

    @ApiModelProperty(name = "loginName", value = "登录名")
    private String loginName;

    @ApiModelProperty(name = "email", value = "邮件地址")
    private String email;

    @ApiModelProperty(name = "verificationCode", value = "验证码")
    private String verificationCode;
}
