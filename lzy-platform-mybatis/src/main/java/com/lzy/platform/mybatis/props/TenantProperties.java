package com.lzy.platform.mybatis.props;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @ClassName TenantProperties
 * @Description 多租户配置类
 * @Author LiZuoYang
 * @Date 2022/6/17 15:10
 **/
@Data
@Configuration
@ConfigurationProperties(value = "tenant")
public class TenantProperties {
    /**
     * 是否开启多租户模式
     */
    private Boolean enable;
    /**
     * 多租户字段名字
     */
    private String column;
    /**
     * 需要排除的多租户的表
     */
    private List<String> exclusionTable;
}
