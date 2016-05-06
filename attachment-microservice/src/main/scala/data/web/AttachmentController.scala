package data.web

import java.io.{BufferedOutputStream, File, FileOutputStream}
import javax.servlet.http.HttpServletResponse

import data.service.AttachmentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.FileSystemResource
import org.springframework.http.ResponseEntity
import org.springframework.util.FileCopyUtils
import org.springframework.web.bind.annotation._
import org.springframework.web.multipart.MultipartFile

/**
  * upload and manage file
  *
  * @author 刘佳兴
  * @version V1.0
  */
@RestController
class AttachmentController {

  @Autowired
  var attachmentService: AttachmentService = _

  /**
    * upload file
    *
    * @param multipartFile multipartFile
    * @param relativePath  business path
    * @return
    */
  @RequestMapping(value = Array("/upload"), method = Array(RequestMethod.POST))
  def upload(@RequestParam(name = "file") multipartFile: MultipartFile, @RequestParam(name = "relativePath") relativePath: String) = {
    if(!multipartFile.isEmpty) {
      ResponseEntity.ok(attachmentService.save(multipartFile, relativePath))
    } else {
      ResponseEntity.notFound()
    }
  }

  /**
    * get file stream
    *
    * @param name uuid
    * @param response response outputstream
    * @return
    */
  @RequestMapping(value = Array("/{name}"), method = Array(RequestMethod.GET))
  def read(@PathVariable(value = "name") name: String, response: HttpServletResponse) = {
    val resource = new FileSystemResource(attachmentService.get(name))
    FileCopyUtils.copy(resource.getInputStream, response.getOutputStream)
    ResponseEntity.ok()
  }

}
