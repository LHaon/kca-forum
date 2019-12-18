package com.mezjh.kcaforum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * @author zjh
 */
@ComponentScan("com.mezjh.kcaforum.*")
@PropertySource(value = "classpath:db.properties")
@ImportResource(value = "classpath:spring-db.xml")
@SpringBootApplication
public class KcaForumApplication {
    public static void main(String[] args) {
        SpringApplication.run(KcaForumApplication.class, args);
    }
}
