package jpa.blog.project.repository;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jpa.blog.project.Entity.QSubject;
import jpa.blog.project.Entity.Subject;
import jpa.blog.project.Entity.SearchSubject;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class SubjectRepositoryQuery {
    private final EntityManager em;

    public List<Subject> findAllByInput(SearchSubject searchSubject, Long id) {
        JPAQueryFactory query = new JPAQueryFactory(em);
        QSubject subject = QSubject.subject;
        List<Subject> empty = new ArrayList<>();

        if (searchSubject.getWeek() != null && searchSubject.getSubjectName() != null && searchSubject.getSubjectName() != ""){
            System.out.println("1");
            return query
                    .select(subject)
                    .from(subject)
                    .where(QSubject.subject.member.memberId.eq(id), weekEq(searchSubject.getWeek()), nameEq(searchSubject.getSubjectName()))
                    .fetch();
        }

        if (searchSubject.getWeek() != null) {
            System.out.println(searchSubject.getWeek()+"2");
            return query
                    .select(subject)
                    .from(subject)
                    .where(QSubject.subject.member.memberId.eq(id), weekEq(searchSubject.getWeek()))
                    .fetch();
        }
        if (searchSubject.getSubjectName() != null && searchSubject.getSubjectName() != "") {
            System.out.println("3");
            return query
                    .select(subject)
                    .from(subject)
                    .where(QSubject.subject.member.memberId.eq(id), nameEq(searchSubject.getSubjectName()))
                    .fetch();
        }
        return empty;
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
        return QSubject.subject.subjectName.contains(name);
    }
}
