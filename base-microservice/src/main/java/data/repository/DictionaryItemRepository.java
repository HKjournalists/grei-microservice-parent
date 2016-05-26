package data.repository;

import data.entity.DictionaryItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author 刘佳兴
 */
public interface DictionaryItemRepository extends JpaRepository<DictionaryItem, Long>, JpaSpecificationExecutor<DictionaryItem> {

}
