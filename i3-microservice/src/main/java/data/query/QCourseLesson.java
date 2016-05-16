package data.query;

import data.entity.CourseLesson;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class QCourseLesson extends CourseLesson implements Specification<CourseLesson> {

    public QCourseLesson() {
    }

    public QCourseLesson(Long id, Long courseId) {
        this.id = id;
        this.courseid = courseId;
    }

    @Override
    public Predicate toPredicate(Root<CourseLesson> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        if(null != this.id) predicates.add(criteriaBuilder.equal(root.get("id"), this.id));
        if(null != this.courseid) predicates.add(criteriaBuilder.equal(root.get("courseid"), this.courseid));

        Predicate[] pre = new Predicate[predicates.size()];
        return criteriaQuery.where(predicates.toArray(pre)).getRestriction();
    }
}
