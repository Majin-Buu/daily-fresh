package cn.com.buu.dailyfresh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class DailyFreshPcApplication {

    public static void main(String[] args) {
        SpringApplication.run(DailyFreshPcApplication.class, args);
    }

}
