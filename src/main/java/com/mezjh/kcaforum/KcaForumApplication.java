package com.mezjh.kcaforum;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author zjh
 */
@Slf4j
@ComponentScan("com.mezjh.kcaforum.*")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class})
@EnableScheduling
public class KcaForumApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(KcaForumApplication.class, args);
        String serverPort = context.getEnvironment().getProperty("server.port");
        log.info("kca started at http://localhost:" + serverPort+ "/index");
    }
}
