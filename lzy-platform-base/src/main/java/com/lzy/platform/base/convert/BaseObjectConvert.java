package com.lzy.platform.base.convert;

import org.mapstruct.InheritConfiguration;

import java.util.List;

/**
 * 共用公共转换接口,可省略，方法在实现类中定义实现即可
 *
 * @author lizuoyang
 * @date 2023/01/10
 */
public interface BaseObjectConvert<S,T> {
    T toTarget(S s);

    @InheritConfiguration(name="toTarget")
    List<T> toTargetList(List<S> sourceList);

    S toSource(T t);

    @InheritConfiguration(name="toSource")
    List<S> toSourceList(List<T> targetlist);
}
