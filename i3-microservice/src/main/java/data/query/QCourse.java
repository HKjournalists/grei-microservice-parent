package data.query;

import data.entity.Course;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 刘佳兴
 */
public class QCourse extends Course implements Specification<Course> {

    @Override
    public Predicate toPredicate(Root<Course> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if (null != this.id) predicates.add(cb.equal(root.get("id"), this.id));
        if (null != this.category) predicates.add(cb.equal(root.get("category"), this.category));
        if (null != this.subcategory) predicates.add(cb.equal(root.get("subcategory"), this.subcategory));
        if (null != this.posted) predicates.add(cb.equal(root.get("posted"), this.posted));

        if (!StringUtils.isEmpty(this.language)) predicates.add(cb.equal(root.get("language"), this.language));
        if (!StringUtils.isEmpty(this.name)) predicates.add(cb.like(root.get("name").as(String.class), "%"+ this.name +"%"));

        criteriaQuery.orderBy(cb.desc(root.get("createddtm")));

        Predicate[] pre = new Predicate[predicates.size()];
        return criteriaQuery.where(predicates.toArray(pre)).getRestriction();
    }

}
