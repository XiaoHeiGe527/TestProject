package com.dmm.common.api.version;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * 版本号匹配拦截器，构建自己的拦截器
 * @author: Dmm
 * @date: 2019/4/18 11:00
 */
public class ApiHandlerMapping extends RequestMappingHandlerMapping {

    private static int latestVersion = 20190412;

    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {

        // 判断是否有@ApiVersion注解，构建基于@ApiVersion的RequestCondition
        ApiVersionRequestCondition condition = buildFrom(AnnotationUtils.findAnnotation(handlerType, ApiVersion.class));
        // 保存最大版本号
        if (condition != null && condition.getVersion() > latestVersion) {

            ApiVersionRequestCondition.setMaxVersion(condition.getVersion());
        }
        return condition;
    }

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        // 判断是否有@ApiVersion注解，构建基于@ApiVersion的RequestCondition
        ApiVersionRequestCondition condition =  buildFrom(AnnotationUtils.findAnnotation(method, ApiVersion.class));

        // 保存最大版本号
        if (condition != null && condition.getVersion() > latestVersion) {
            System.out.println(condition.getVersion());
            ApiVersionRequestCondition.setMaxVersion(condition.getVersion());
        }
        return condition;
    }


    private ApiVersionRequestCondition buildFrom(ApiVersion apiVersion) {

//        if (Objects.isNull(apiVersion)) {
//            return null;
//        }
//        Assert.isTrue(apiVersion.value()>=20190412,"Api Version Must be greater than or equal to 1");
        return apiVersion == null ? null : new ApiVersionRequestCondition(apiVersion.value());
    }

    /**
     * 修改最大版本号
     * @param maxVersion
     */
    public static void setLatestVersion(int maxVersion) {

        ApiHandlerMapping.latestVersion = maxVersion;
    }
}
