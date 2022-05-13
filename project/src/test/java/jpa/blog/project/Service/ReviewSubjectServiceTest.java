package jpa.blog.project.Service;

import jpa.blog.project.Entity.Member;
import jpa.blog.project.Entity.ReviewSubject;
import jpa.blog.project.Entity.Subject;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback(value = false)
class ReviewSubjectServiceTest {
    @Autowired
    ReviewSubjectService reviewSubjectService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    MemberService memberService;

//    @Test
//    public void pagingTest(){
//        Subject subject = new Subject("과목");
//        Member member = new Member("박세헌", "컴퓨터");
//        ReviewSubject reviewSubject1 = new ReviewSubject("1리뷰", "1", LocalDate.now());
//        ReviewSubject reviewSubject2 = new ReviewSubject("2리뷰", "1", LocalDate.now());
//        ReviewSubject reviewSubject3 = new ReviewSubject("3리뷰", "1", LocalDate.now());
//        ReviewSubject reviewSubject4 = new ReviewSubject("4리뷰", "1", LocalDate.now());
//        ReviewSubject reviewSubject5 = new ReviewSubject("5리뷰", "1", LocalDate.now());
//
//        memberService.join(member);
//        subjectService.addSubject(member, subject);
//        reviewSubjectService.addReviewSubject(subject, reviewSubject1);
//        reviewSubjectService.addReviewSubject(subject, reviewSubject2);
//        reviewSubjectService.addReviewSubject(subject, reviewSubject3);
//        reviewSubjectService.addReviewSubject(subject, reviewSubject4);
//        reviewSubjectService.addReviewSubject(subject, reviewSubject5);
//
//        PageRequest pr = PageRequest.of(0, 2);
//        Page<ReviewSubject> reviews = reviewSubjectService.findReviews(subject.getSubjectId(), pr);
//        System.out.println(reviews.getTotalElements());
//        System.out.println(reviews.getTotalPages());
//        System.out.println(reviews.getContent().get(0).getTitle());
//        System.out.println(reviews.getNumber());
//        System.out.println(reviews.getNumberOfElements());
//        System.out.println(reviews.getSize());
//    }
}