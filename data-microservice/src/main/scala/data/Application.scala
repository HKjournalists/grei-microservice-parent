package data

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

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
@EnableDiscoveryClient
@EnableZuulProxy
class Application
