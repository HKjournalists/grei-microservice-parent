package services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * @author 刘佳兴
 * @version V1.0
 */
@SpringBootApplication
@EnableSidecar
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
