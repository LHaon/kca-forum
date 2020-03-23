package com.mezjh.kcaforum.common.utils.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Druid数据源配置类，将jasypt解密后的内容自己配置到数据源
 *
 * @author zjh
 * @date 2019/12/18
 */
@Slf4j
@Configuration
public class DruidConfig {

    @Value("${db.password}")
    private String password;
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.driverClassName}")
    private String driver;

    @Bean(value = "dataSource", name = "dataSource")
    public DataSource initDataSource() {
        log.info("The datasource initializing...");
        DruidDataSource dataSource = new DruidDataSource();
        Properties properties = new Properties();
        try {
            //FileInputStream in = new FileInputStream("./db.properties");
            InputStream in = properties.getClass().getResourceAsStream("/db.properties");
            properties.load(in);
        } catch (Exception e) {
            log.warn("The datasource profile load failed! Message={}", e.getMessage());
        }
        dataSource.configFromPropety(properties);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        log.info("The datasource initializing complete!");
        return dataSource;
    }
}
