package data

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.zuul.EnableZuulProxy

/**
  * Application
  *
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
@EnableZuulProxy
class Application
