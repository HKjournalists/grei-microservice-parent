package services

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

/**
  * Application
  * Created by 刘佳兴 on 16-4-19.
  */

object Application {
  def main(args: Array[String]) {
    SpringApplication.run(classOf[Application])
  }
}

@SpringBootApplication
@EnableEurekaServer
class Application {

}
