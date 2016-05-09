package data.entity.query;

import data.entity.Attachment;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 刘佳兴
 * @version V1.0
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class QAttachment extends Attachment implements Specification<Attachment> {

    public QAttachment(String name) {
        this.name = name;
    }

    @Override
    public Predicate toPredicate(Root<Attachment> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if(this.id != null) predicates.add(cb.equal(root.get("id"), this.id));

        if(!StringUtils.isEmpty(this.name)) predicates.add(cb.equal(root.get("name"), this.name));

        Predicate[] pre = new Predicate[predicates.size()];
        return query.where(predicates.toArray(pre)).getRestriction();
    }
}
