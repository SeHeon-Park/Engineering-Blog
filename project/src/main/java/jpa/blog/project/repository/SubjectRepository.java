package jpa.blog.project.repository;

import jpa.blog.project.Entity.Subject;
import jpa.blog.project.Entity.SubjectWeek;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectRepository extends JpaRepository<Subject, Long> {
    @Query("select s from Subject s where s.member.memberId = :memberId")
    List<Subject> findSubjectsByMemberId(@Param("memberId") Long memberId);
}