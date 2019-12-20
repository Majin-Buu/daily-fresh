package cn.com.buu.dailyfresh.controller.uac;

import cn.com.buu.dailyfresh.module.vo.BaseResult;
import cn.com.buu.dailyfresh.module.vo.UacLoginVo;
import cn.com.buu.dailyfresh.service.uac.UacService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 用户控制
 *
 * @author: buu
 */
@RestController
@RequestMapping("/fresh/uac")
@Slf4j
public class UacController {

    @Resource
    private UacService uacService;

    @PostMapping("/login")
    @ApiOperation(httpMethod = "POST", value = "用户登录")
    public BaseResult login(@RequestBody UacLoginVo uacLoginVo) {
        log.info("用户登录 uacLoginVo={}", uacLoginVo);
        return uacService.login(uacLoginVo);

    }

}
