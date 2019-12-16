package com.xxl.job.client.spring.boot.autoconfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * client端配置类
 *
 * @author Dr.YangLong
 * @date 2019-12-16
 */
@ConfigurationProperties(prefix = "xxl.job")
public class ClientProperties {
    private Executor executor = new Executor();
    private String accessToken;
    private String adminAddress;

    public static class Executor {
        private String appName;
        private Integer port;
        private String ip;
        private String logPath;
        private Integer logRetentionDays;

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public Integer getPort() {
            return port;
        }

        public void setPort(int port) {
            this.port = port;
        }

        public String getIp() {
            return ip;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public String getLogPath() {
            return logPath;
        }

        public void setLogPath(String logPath) {
            this.logPath = logPath;
        }

        public Integer getLogRetentionDays() {
            return logRetentionDays;
        }

        public void setLogRetentionDays(int logRetentionDays) {
            this.logRetentionDays = logRetentionDays;
        }
    }

    public Executor getExecutor() {
        return executor;
    }

    public void setExecutor(Executor executor) {
        this.executor = executor;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAdminAddress() {
        return adminAddress;
    }

    public void setAdminAddress(String adminAddress) {
        this.adminAddress = adminAddress;
    }
}
