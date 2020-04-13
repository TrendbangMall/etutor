package com.etutor.utils;

import com.github.dozermapper.core.Mapper;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.Collection;
import java.util.List;

/**
 * @author huangyuan
 * @date 2019/8/28
 */
public class DozerUtils {

    /**
     * 封装 集合转换
     *
     * @param mapper            转换器
     * @param sourceList        原始集合数据
     * @param targetObjectClass 目标类
     * @param <T>               目标泛型
     * @param <S>               原始泛型
     */
    public static <T, S> List<T> mapList(final Mapper mapper, Collection<S> sourceList, Class<T> targetObjectClass) {
        List<T> targetList = Lists.newArrayListWithExpectedSize(sourceList != null ? sourceList.size() : 0);
        if (CollectionUtils.isNotEmpty(sourceList)) {
            for (S s : sourceList) {
                targetList.add(mapper.map(s, targetObjectClass));
            }
        }
        return targetList;
    }

    /**
     * 封装转换 单一对象
     *
     * @param mapper            转换器
     * @param source            原始对象
     * @param targetObjectClass 目标对象类别
     * @param <S>               原始泛型
     * @param <T>               目标泛型
     */
    public static <S, T> T map(final Mapper mapper, S source, Class<T> targetObjectClass) {
        if (source != null) {
            return mapper.map(source, targetObjectClass);
        }
        return null;
    }
}
