package services

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.EnableAutoConfiguration
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.config.server.EnableConfigServer
import org.springframework.context.annotation.Configuration

/**
  * Application
  * Created by 刘佳兴 on 16-4-19.
  */

object Application {
  def main(args: Array[String]) {
    SpringApplication.run(classOf[Application])
  }
}

@Configuration
@EnableAutoConfiguration
@EnableDiscoveryClient
@EnableConfigServer
class Application {

}
