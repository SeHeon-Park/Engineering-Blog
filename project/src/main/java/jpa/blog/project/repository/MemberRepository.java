package jpa.blog.project.repository;


import jpa.blog.project.Entity.Member;
import jpa.blog.project.Entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {
}