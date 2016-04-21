package services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * Application
 * Created by 刘佳兴 on 16-4-21.
 */
@SpringBootApplication
@EnableSidecar
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
