package com.xxl.job.executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 调度客户端，使用starter
 *
 * @author Dr.YangLong
 * @date 2019-12-16
 */
@SpringBootApplication(scanBasePackages = {"com.xxl.job"})
public class ClientApplication {
    public static void main(String[] args) {
        System.out.println("=========engine start==========");
        SpringApplication.run(ClientApplication.class, args);
        System.out.println("=========engine started==========");
    }
}
