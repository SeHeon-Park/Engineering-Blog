package jpa.blog.project.repository;

import com.querydsl.core.types.ExpressionUtils;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jpa.blog.project.Entity.QSubject;
import jpa.blog.project.Entity.Subject;
import jpa.blog.project.Entity.SubjectWeek;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SubjectRepositoryQuery {
    private final EntityManager em;

    public List<Subject> findAllBySubjectWeek(SubjectWeek subjectWeek){
        JPAQueryFactory query = new JPAQueryFactory(em);
        QSubject subject = QSubject.subject;
        return query
                .select(subject)
                .from(subject)
                .where(
                        ExpressionUtils.or(
                        weekEq(subjectWeek.getWeek()),
                        nameEq(subjectWeek.getSubjectName()))
                )
                .fetch();
    }

    private BooleanExpression weekEq(String week){
        if (week == null) {
            return null;
        }
        return QSubject.subject.week.eq(week);
    }

    private BooleanExpression nameEq(String name){
        if (name == null) {
            return null;
        }
        return QSubject.subject.subjectName.eq(name);
    }
}
