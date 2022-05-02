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
        m.setGrade(4);
        m.setStudentNumber("201701234");
        memberService.join(m);
//        Subject s1 = new Subject("프로그래밍 어론", 3);
//        Subject s2 = new Subject("빅데이터 처리", 3);
//        subjectService.addSubject(m, s1);
//        subjectService.addSubject(m, s2);
//
//        List<Subject> findResult = subjectService.findSubject(m.getMemberId());
//        findResult.forEach(s->assertThat(s.getMember().getMemberId()).isEqualTo(m.getMemberId()));

        Subject s1 = new Subject("금", "고급문제해결", 3);
        Subject s2 = new Subject("금", "빅데이터처리", 3);
        Subject s3 = new Subject("금", "캡스톤설계", 3);
        Subject s4 = new Subject("금", "프로그래밍어론", 3);
        Subject s5 = new Subject("금", "기초회화연습", 2);
        Subject s6 = new Subject("금", "일본어강독연습", 2);
        Subject s7 = new Subject("금", "고급문제처리", 2);
        subjectService.addSubject(m, s1);
        subjectService.addSubject(m, s2);
        subjectService.addSubject(m, s3);
        subjectService.addSubject(m, s4);
        subjectService.addSubject(m, s5);
        subjectService.addSubject(m, s6);
        subjectService.addSubject(m, s7);
    }
}