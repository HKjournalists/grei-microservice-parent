package data.query;

import data.entity.User;
import lombok.Data;
import lombok.Setter;
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
public class QUser extends User implements Specification<User> {

    @Setter
    private String equalLoginName;

    @Override
    public Predicate toPredicate(Root<User> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if(!StringUtils.isEmpty(equalLoginName)) predicates.add(cb.equal(root.get("loginName"), equalLoginName));
        if(!StringUtils.isEmpty(this.status)) predicates.add(cb.equal(root.get("status"), this.status));
        if(!StringUtils.isEmpty(this.loginName)) predicates.add(cb.like(root.get("loginName"), "%"+ this.loginName +"%"));
        if(!StringUtils.isEmpty(this.email)) predicates.add(cb.like(root.get("email"), "%"+ this.email +"%"));
        if(!StringUtils.isEmpty(this.phone)) predicates.add(cb.like(root.get("phone"), "%"+ this.phone +"%"));

        Predicate[] pre = new Predicate[predicates.size()];
        return criteriaQuery.where(predicates.toArray(pre)).getRestriction();
    }

}
