package services

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.cloud.netflix.sidecar.EnableSidecar

/**
  * @author 刘佳兴
  * @version V1.0
  */

object Application {
  def main(args: Array[String]) {
    SpringApplication.run(Application)
  }
}

@SpringBootApplication
@EnableSidecar
class Application {

}
