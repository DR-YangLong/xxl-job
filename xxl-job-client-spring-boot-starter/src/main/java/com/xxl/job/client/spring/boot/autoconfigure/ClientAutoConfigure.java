package com.xxl.job.client.spring.boot.autoconfigure;

import com.xxl.job.core.executor.impl.XxlJobSpringExecutor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Dr.YangLong
 * @date 2019-12-16
 */
@Configuration
@EnableConfigurationProperties(ClientProperties.class)
public class ClientAutoConfigure {

    @Bean
    public XxlJobSpringExecutor jobSpringExecutor(ClientProperties clientProperties) {
        XxlJobSpringExecutor xxlJobSpringExecutor = new XxlJobSpringExecutor();
        xxlJobSpringExecutor.setAdminAddresses(clientProperties.getAdminAddress());
        xxlJobSpringExecutor.setAccessToken(clientProperties.getAccessToken());
        xxlJobSpringExecutor.setAppName(clientProperties.getExecutor().getAppName());
        xxlJobSpringExecutor.setIp(clientProperties.getExecutor().getIp());
        xxlJobSpringExecutor.setPort(clientProperties.getExecutor().getPort());
        xxlJobSpringExecutor.setLogPath(clientProperties.getExecutor().getLogPath());
        xxlJobSpringExecutor.setLogRetentionDays(clientProperties.getExecutor().getLogRetentionDays());
        return xxlJobSpringExecutor;
    }
}
