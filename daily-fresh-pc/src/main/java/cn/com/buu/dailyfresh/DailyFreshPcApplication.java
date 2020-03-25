package cn.com.buu.dailyfresh;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan(value = "cn.com.buu.dailyfresh.dao")
public class DailyFreshPcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailyFreshPcApplication.class, args);
    }

}
