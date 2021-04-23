package org.abc.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * 对象转换工具类
 *
 * @author mjc
 */
@Slf4j
public class BeanCopyUtils {

    private BeanCopyUtils() {
    }

    public static <T, M> List<M> copyBeanList(List<T> sourceList, Class<M> targetClass) {
        if (CollectionUtils.isEmpty(sourceList)) {
            return new ArrayList<>(0);
        }
        return sourceList.stream().map(source -> {
            try {
                M target = targetClass.newInstance();
                BeanUtils.copyProperties(source, target);
                return target;
            } catch (Exception e) {
                log.error(e.getMessage());
            }
            return null;

        }).filter(Objects::nonNull).collect(Collectors.toList());
    }

    public static <T, M> M copyBean(T source, Class<M> targetClass) throws Exception {
        if (Objects.nonNull(source)) {
            M target;
            try {
                target = targetClass.newInstance();
                BeanUtils.copyProperties(source, target);
                return target;
            } catch (InstantiationException | IllegalAccessException e) {
                log.error("target class new instance error:", e);
            }
        }
        throw new Exception("数据不存在");
    }
}
