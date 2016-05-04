package services

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.{EnableAutoConfiguration, SpringBootApplication}
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.config.server.EnableConfigServer
import org.springframework.context.annotation.Configuration

/**
  * @author 刘佳兴
  * @version V1.0
  */

object Application {
  def main(args: Array[String]) {
    SpringApplication.run(classOf[Application])
  }
}

@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
class Application
