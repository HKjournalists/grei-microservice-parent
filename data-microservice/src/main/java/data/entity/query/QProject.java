package data.entity.query;

import data.entity.Project;
import org.springframework.data.jpa.domain.Specification;

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
public class QProject extends Project implements Specification<Project> {

    @Override
    public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        predicates.add(cb.equal(root.get("id"), this.id));

        Predicate[] pre = new Predicate[predicates.size()];
        return query.where(predicates.toArray(pre)).getRestriction();
    }

}
