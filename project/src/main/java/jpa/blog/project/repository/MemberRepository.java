package jpa.blog.project.repository;


import jpa.blog.project.Entity.Member;
import jpa.blog.project.Entity.ReviewSubject;
import jpa.blog.project.Entity.Subject;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findMemberByMemberId(Long id);
    Optional<Member> findByUid(String uid);
    boolean existsByUid(String uid);
}