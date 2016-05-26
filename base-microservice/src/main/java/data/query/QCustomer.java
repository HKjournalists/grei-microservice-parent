package data.query;

import data.entity.Customer;
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
public class QCustomer extends Customer implements Specification<Customer> {

    @Override
    public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if(null != this.id) predicates.add(cb.equal(root.get("id"), this.id));

        if (!StringUtils.isEmpty(this.email)) predicates.add(cb.equal(root.get("email"), this.email));
        if (!StringUtils.isEmpty(this.countryPhoneCode)) predicates.add(cb.equal(root.get("countryPhoneCode"), this.countryPhoneCode));
        if (!StringUtils.isEmpty(this.mobilePhone)) predicates.add(cb.equal(root.get("mobilePhone"), this.mobilePhone));
        if (!StringUtils.isEmpty(this.invitecode)) predicates.add(cb.equal(root.get("invitecode"), this.invitecode));

        Predicate[] pre = new Predicate[predicates.size()];
        return criteriaQuery.where(predicates.toArray(pre)).getRestriction();
    }

}
