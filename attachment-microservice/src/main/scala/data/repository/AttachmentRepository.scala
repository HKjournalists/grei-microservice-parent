package data.repository

import data.entity.Attachment
import org.springframework.data.jpa.repository.{JpaRepository, JpaSpecificationExecutor}
import org.springframework.stereotype.Repository

/**
  * attachment repository
  *
  * @author 刘佳兴
  * @version V1.0
  */
@Repository
trait AttachmentRepository extends JpaRepository[Attachment, java.lang.Long] with JpaSpecificationExecutor[Attachment]
