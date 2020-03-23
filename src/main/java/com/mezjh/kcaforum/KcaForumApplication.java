package com.mezjh.kcaforum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zjh
 */
@ComponentScan("com.mezjh.kcaforum.*")
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class,
    DataSourceTransactionManagerAutoConfiguration.class})
public class KcaForumApplication {
    public static void main(String[] args) {
        SpringApplication.run(KcaForumApplication.class, args);
    }
}
