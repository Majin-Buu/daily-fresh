package cn.com.buu.dailyfreshpc.service.uac;

import cn.com.buu.dailyfreshpc.module.domain.PcUacUser;
import cn.com.buu.dailyfreshpc.module.vo.BaseResult;
import cn.com.buu.dailyfreshpc.module.vo.uac.UacInsertVo;
import cn.com.buu.dailyfreshpc.module.vo.uac.UacLoginVo;
import cn.com.buu.dailyfreshpc.service.BaseService;

public interface UacService extends BaseService {

    PcUacUser login(UacLoginVo uacLoginVo);

    PcUacUser insert(UacInsertVo uacInsertVo);

}
