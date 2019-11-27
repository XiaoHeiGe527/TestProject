package com.dmm.common.api.version.string;

import com.dmm.utils.ApiVersionCut;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.web.servlet.mvc.condition.RequestCondition;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import java.lang.reflect.Method;

/**
 * 版本号匹配拦截器，构建自己的拦截器 版本号的设置
 * @author: Dmm
 * @date: 2019/4/18 11:00
 */
public class ApiHandlerMappingString extends RequestMappingHandlerMapping {

    private static String latestVersion = "0.0.0.0";

    @Override
    protected RequestCondition<?> getCustomTypeCondition(Class<?> handlerType) {

        // 判断是否有@ApiVersion注解，构建基于@ApiVersion的RequestCondition
        ApiVersionRequestCondition condition = buildFrom(AnnotationUtils.findAnnotation(handlerType, ApiVersionString.class));
        // 保存最大版本号condition.getVersion() > latestVersion
        if (condition != null && ApiVersionCut.versionCutInt(condition.getVersion(),latestVersion)>0) {

            ApiVersionRequestCondition.setMaxVersion(condition.getVersion());
        }
        return condition;
    }

    @Override
    protected RequestCondition<?> getCustomMethodCondition(Method method) {
        // 判断是否有@ApiVersion注解，构建基于@ApiVersion的RequestCondition
        ApiVersionRequestCondition condition =  buildFrom(AnnotationUtils.findAnnotation(method, ApiVersionString.class));

        // 保存最大版本号 && condition.getVersion() > latestVersion
        if (condition != null && ApiVersionCut.versionCutInt(condition.getVersion(),latestVersion)>0) {

            ApiVersionRequestCondition.setMaxVersion(condition.getVersion());
        }
        return condition;
    }


    private ApiVersionRequestCondition buildFrom(ApiVersionString apiVersion) {

        return apiVersion == null ? null : new ApiVersionRequestCondition(apiVersion.value());
    }

    /**
     * 修改最大版本号
     * @param maxVersion
     */
    public static void setLatestVersion(String maxVersion) {

        ApiHandlerMappingString.latestVersion = maxVersion;
    }
}
