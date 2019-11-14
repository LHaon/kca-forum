package com.mezjh.kcaforum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author zjh
 */
@ComponentScan("com.mezjh.kcaforum.*")
@SpringBootApplication
public class KcaForumApplication {
    public static void main(String[] args) {
        SpringApplication.run(KcaForumApplication.class, args);
    }
}
