package com.lzy.platform.mybatis.config;

import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import com.lzy.platform.mybatis.props.TenantProperties;
import com.lzy.platform.springboot.utils.LzyCloudAuthUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.NullValue;
import net.sf.jsqlparser.expression.StringValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName TenantConfig
 * @Description 多租户配置中心
 * @Author LiZuoYang
 * @Date 2022/6/17 15:16
 **/
@Slf4j
@Configuration
@RequiredArgsConstructor(onConstructor_ = @Autowired)
@AutoConfigureBefore(MybatisPlusConfig.class)
public class TenantConfig {
    private final TenantProperties tenantProperties;

    /**
     * 新多租户插件配置,一缓和二缓遵循mybatis的规则,
     * 需要设置 MybatisConfiguration#useDeprecatedExecutor = false
     * 避免缓存万一出现问题
     *
     * @return TenantLineInnerInterceptor
     */
    @Bean
    public TenantLineInnerInterceptor innerInterceptor() {
        return new TenantLineInnerInterceptor(new TenantLineHandler() {
            /**
             * 获取租户id
             *
             * @return {@link Expression}
             */
            @Override
            public Expression getTenantId() {
                String tenantId = LzyCloudAuthUtils.getTenantId();
                log.info("TenantConfig.getTenantId() tenantId: {}", tenantId);
                if (tenantId != null) {
                    return new StringValue(LzyCloudAuthUtils.getTenantId());
                }
                return new NullValue();
            }

            /**
             * 获取多租户的字段名
             * @return String
             */
            @Override
            public String getTenantIdColumn() {
                return tenantProperties.getColumn();
            }

            /**
             * 过滤不需要根据租户隔离的表
             * 这是 default 方法,默认返回 false 表示所有表都需要拼多租户条件
             * @param tableName 表名
             */
            @Override
            public boolean ignoreTable(String tableName) {
                return tenantProperties.getExclusionTable().stream().anyMatch(
                        (t) -> t.equalsIgnoreCase(tableName)
                );
            }
        });
    }
}
