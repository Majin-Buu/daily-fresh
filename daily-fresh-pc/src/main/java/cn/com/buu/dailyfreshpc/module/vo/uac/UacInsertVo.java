package cn.com.buu.dailyfreshpc.module.vo.uac;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = true)
public class UacInsertVo extends UacUserInfo implements Serializable {

    private static final long serialVersionUID = 532146347485213676L;

    @ApiModelProperty(name = "insertType", value = "注册方式 1: 手机号 2: 邮箱 3: 用户名")
    private Integer insertType;
}
