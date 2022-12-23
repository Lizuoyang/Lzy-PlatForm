package com.lzy.platform.mybatis.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.lzy.platform.base.domain.LzyCloudUser;
import com.lzy.platform.base.enums.BaseEntityEnum;
import com.lzy.platform.springboot.utils.LzyCloudAuthUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * lzy-cloud mybatis-plus 自动填充数据处理器
 *
 * @author lizuoyang
 * @date 2022/12/22
 */
@Component
public class LzyCloudMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Object creator = getFieldValByName(BaseEntityEnum.CREATOR.entity, metaObject);
        LzyCloudUser gitEggUser = LzyCloudAuthUtils.getCurrentUser();
        if (null == creator && null != gitEggUser) {
            setFieldValByName(BaseEntityEnum.CREATOR.entity, gitEggUser.getId(), metaObject);
        }
        Object createTime = getFieldValByName(BaseEntityEnum.CREATE_TIME.entity, metaObject);
        if (null == createTime) {
            setFieldValByName(BaseEntityEnum.CREATE_TIME.entity, LocalDateTime.now(), metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
        Object operator = getFieldValByName(BaseEntityEnum.OPERATOR.entity, metaObject);
        LzyCloudUser gitEggUser = LzyCloudAuthUtils.getCurrentUser();
        if (null == operator && null != gitEggUser) {
            setFieldValByName(BaseEntityEnum.OPERATOR.entity, gitEggUser.getId(), metaObject);
        }
        Object updateTime = getFieldValByName(BaseEntityEnum.UPDATE_TIME.entity, metaObject);
        if (null == updateTime) {
            setFieldValByName(BaseEntityEnum.UPDATE_TIME.entity, LocalDateTime.now(), metaObject);
        }
    }
}
