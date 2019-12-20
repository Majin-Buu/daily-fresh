package cn.com.buu.dailyfresh.service.uac;

import cn.com.buu.dailyfresh.module.vo.BaseResult;
import cn.com.buu.dailyfresh.module.vo.UacLoginVo;

public interface UacService {

    BaseResult login(UacLoginVo uacLoginVo);

}
