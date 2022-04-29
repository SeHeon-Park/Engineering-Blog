package jpa.blog.project.Service;

import jpa.blog.project.Entity.Member;
import jpa.blog.project.Entity.Subject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback(value = false)
class SubjectServiceTest {

    @Autowired SubjectService subjectService;
    @Autowired MemberService memberService;
    @PersistenceContext EntityManager em;

    @Test
    public void addSubjectTest(){
        Member m = new Member("박세헌", "컴퓨터전자시스템공학부");
        memberService.join(m);
//        Subject s1 = new Subject("프로그래밍 어론", 3);
//        Subject s2 = new Subject("빅데이터 처리", 3);
//        subjectService.addSubject(m, s1);
//        subjectService.addSubject(m, s2);
//
//        List<Subject> findResult = subjectService.findSubject(m.getMemberId());
//        findResult.forEach(s->assertThat(s.getMember().getMemberId()).isEqualTo(m.getMemberId()));

        Subject subject = new Subject("고급문제해결", 3);
        subject.setWeek("금");
        subjectService.addSubject(m, subject);
    }
}