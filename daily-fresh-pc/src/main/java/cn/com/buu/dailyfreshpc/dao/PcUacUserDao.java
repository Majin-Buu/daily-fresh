package cn.com.buu.dailyfreshpc.dao;

import cn.com.buu.dailyfreshpc.module.domain.PcUacUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>自动生成工具：mybatis-dsc-generator</p>
 *
 * <p>说明： 操作员表数据访问层</p>
 *
 * @version: v1.0
 * @author: buu
 */
public interface PcUacUserDao extends BaseMapper<PcUacUser> {

    PcUacUser findUserByAccount(String userAccount);

}
