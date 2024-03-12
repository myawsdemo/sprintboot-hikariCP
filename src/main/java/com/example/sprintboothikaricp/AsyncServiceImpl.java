package com.example.sprintboothikaricp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
@Slf4j
public class AsyncServiceImpl {

    @Autowired
    JdbcTemplate jdbcTemplate;
    @Async // 设置方法为异步任务
    public void test() {
        for (int i = 0; i < 100000000; i++) {
            final int index = i;
            try {
                String name = "Name" + index;
                jdbcTemplate.execute("insert into test_insert(name) values('" + name + "')");

                log.info("===============Inserted {} rows===========", index);
                Thread.sleep(3000);

            } catch (Exception e) {
                handleException(e);
            }
        }
        System.out.println("数据处理完毕");
    }


    @ExceptionHandler(Exception.class)
    public void handleException(Exception e) {
        // 处理异常，例如记录日志或其他操作
        log.error("***************Inserted Errors**************", e);
    }

}
