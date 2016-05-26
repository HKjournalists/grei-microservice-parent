package data.query;

import data.entity.Dictionary;
import data.entity.DictionaryItem;
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
public class QDictionaryItem extends DictionaryItem implements Specification<DictionaryItem> {

    @Setter
    private String equalCode;

    @Override
    public Predicate toPredicate(Root<DictionaryItem> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<>();

        if(!StringUtils.isEmpty(this.equalCode)) predicates.add(cb.equal(root.get("code"), this.equalCode));
        if(!StringUtils.isEmpty(this.code)) predicates.add(cb.like(root.get("code"), "%"+this.code+"%"));
        if(!StringUtils.isEmpty(this.name)) predicates.add(cb.like(root.get("name"), "%"+this.name+"%"));

        Predicate[] pre = new Predicate[predicates.size()];
        return criteriaQuery.where(predicates.toArray(pre)).getRestriction();
    }

}
