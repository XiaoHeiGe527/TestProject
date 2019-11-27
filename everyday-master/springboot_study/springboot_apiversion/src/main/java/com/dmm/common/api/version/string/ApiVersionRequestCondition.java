package com.dmm.common.api.version.string;

import com.dmm.utils.ApiVersionCut;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 处理字符串 处理器
 * @author: Dmm
 * @date: 2019/4/18 10:58
 */
public class ApiVersionRequestCondition implements RequestCondition<ApiVersionRequestCondition> {

    /**
     * 用于匹配request中的版本号  1.0.0.0
     */
    private static final Pattern VERSION_PATTERN = Pattern.compile("^([1-9]\\d|\\d)(\\.([1-9]\\d|\\d)){3}$");
    /**
     * 保存当前的版本号
     */

    private String version;
    /**
     * 保存所有接口的最大版本号
     */

    private static String maxVersion = "0.0.0.0";


    public ApiVersionRequestCondition(String version) {

        this.version = version;
    }


    @Override
    public ApiVersionRequestCondition combine(ApiVersionRequestCondition apiVersionRequestCondition) {
        return new ApiVersionRequestCondition(apiVersionRequestCondition.version);
    }

    @Override
    public ApiVersionRequestCondition getMatchingCondition(HttpServletRequest httpServletRequest) {

        String s= httpServletRequest.getHeader("api-version");

        if(s==null || "".equals(s)){
            return null;
        }

        //正则匹配请求的uri，看是否有版本号 1.0.0.0
        Matcher matcher = VERSION_PATTERN.matcher(s);

        if (matcher.find()) {
            String versionNo = matcher.group(0);

            // 超过当前最大版本号或者低于最低的版本号均返回不匹配 修改 todo

            if(ApiVersionCut.versionCutInt(versionNo,maxVersion) <=0 && ApiVersionCut.versionCutInt(versionNo,this.version)>=0){
                return this;
            }

        }
        return null;
    }

    @Override
    public int compareTo(ApiVersionRequestCondition apiVersionRequestCondition, HttpServletRequest httpServletRequest) {
        // 以版本号大小判定优先级，越高越优先
        return ApiVersionCut.versionCutInt(apiVersionRequestCondition.version,this.version);
    }

    public String getVersion() {
        return version;
    }

    public static void setMaxVersion(String maxVersion) {

        //ApiHandlerMappingString.setLatestVersion(maxVersion);
        ApiVersionRequestCondition.maxVersion = maxVersion;

    }

}
