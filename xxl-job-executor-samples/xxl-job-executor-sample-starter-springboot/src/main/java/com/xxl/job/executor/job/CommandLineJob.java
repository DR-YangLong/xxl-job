package com.xxl.job.executor.job;

import com.xxl.job.core.biz.model.ReturnT;
import com.xxl.job.core.handler.IJobHandler;
import com.xxl.job.core.handler.annotation.JobHandler;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 简单的打印收到时间和参数
 *
 * @author Dr.YangLong
 * @date 2019-12-16
 */
@JobHandler(value="starterJob")
@Component
public class CommandLineJob extends IJobHandler{

    @Override
    public ReturnT<String> execute(String param) throws Exception {
        System.out.printf("收到请求，参数%s，日期%s\n",param, LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH:mm:ss")));
        return SUCCESS;
    }
}
