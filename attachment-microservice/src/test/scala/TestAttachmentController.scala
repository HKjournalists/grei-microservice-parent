import java.io.File
import java.net.URI

import org.junit.{Assert, Test}
import org.springframework.core.io.FileSystemResource
import org.springframework.util.LinkedMultiValueMap
import org.springframework.web.client.RestTemplate

/**
  * @author 刘佳兴
  * @version V1.0
  */
class TestAttachmentController {

  @Test
  def testUpload(): Unit = {
    val restTemplate = new RestTemplate()
    val uri = new URI("http://localhost:9000/upload")
    val resource = new FileSystemResource("/home/liujx/Pictures/Selection_003.png")
    val multiValueMap = new LinkedMultiValueMap[String, Object]()
    multiValueMap.add("file", resource)
    multiValueMap.add("relativePath", "/")

    val result = restTemplate.postForObject(uri, multiValueMap, classOf[String])
    Assert.assertNotNull(result)
  }

  @Test
  def testReadFile: Unit = {
    val restTemplate = new RestTemplate()
    val uri = new URI("http://localhost:9000/read/Selection_003.png")

    val result = restTemplate.getForObject(uri, classOf[File])
    println(result)
  }

}
