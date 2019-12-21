package cn.com.buu.dailyfreshpc.controller.uac;

import cn.com.buu.dailyfreshpc.module.vo.BaseResult;
import cn.com.buu.dailyfreshpc.module.vo.uac.UacInsertVo;
import cn.com.buu.dailyfreshpc.module.vo.uac.UacLoginVo;
import cn.com.buu.dailyfreshpc.service.uac.UacService;
import io.swagger.annotations.Api;
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
@Api(value = "操作员控制模块")
public class UacController {

    @Resource
    private UacService uacService;

    @PostMapping("/login")
    @ApiOperation(httpMethod = "POST", value = "操作员登录")
    public BaseResult login(@RequestBody UacLoginVo uacLoginVo) {
        log.info("操作员登录 uacLoginVo={}", uacLoginVo);
        return BaseResult.ok(uacService.login(uacLoginVo));

    }

    @PostMapping("/insert")
    @ApiOperation(httpMethod = "POST", value = "操作员添加")
    public BaseResult login(@RequestBody UacInsertVo uacInsertVo) {
        log.info("操作员添加 uacInsertVo={}", uacInsertVo);
        return BaseResult.ok(uacService.insert(uacInsertVo));

    }

}
