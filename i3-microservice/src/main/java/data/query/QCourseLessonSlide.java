package data.query;

import data.entity.CourseLesson;
import data.entity.CourseLessonSlide;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;


public class QCourseLessonSlide extends CourseLessonSlide implements Specification<CourseLessonSlide> {

    public QCourseLessonSlide() {
    }

    @Override
    public Predicate toPredicate(Root<CourseLessonSlide> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        if(null != this.id) predicates.add(criteriaBuilder.equal(root.get("id"), this.id));
        if(null != this.courseid) predicates.add(criteriaBuilder.equal(root.get("courseid"), this.courseid));
        if(null != this.lessonid) predicates.add(criteriaBuilder.equal(root.get("lessonid"), this.lessonid));

        Predicate[] pre = new Predicate[predicates.size()];
        return criteriaQuery.where(predicates.toArray(pre)).getRestriction();
    }
}
