package data.entity;

import lombok.Data;
import lombok.extern.java.Log;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

/**
 * project
 * Created by 刘佳兴 on 16-4-21.
 */
@Entity
@Table(name = "project")
@Data
public class Project implements Specification<Project> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    protected Long id;

    @Column(name = "projectname")
    protected String projectname;

    @Override
    public Predicate toPredicate(Root<Project> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        List<Predicate> predicates = new ArrayList<Predicate>();

        predicates.add(cb.equal(root.get("id"), this.id));

        Predicate[] pre = new Predicate[predicates.size()];
        return query.where(predicates.toArray(pre)).getRestriction();
    }
}
