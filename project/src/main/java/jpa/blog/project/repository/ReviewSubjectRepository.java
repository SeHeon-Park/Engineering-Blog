package jpa.blog.project.repository;


import jpa.blog.project.Entity.ReviewSubject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ReviewSubjectRepository extends JpaRepository<ReviewSubject, Long> {

    @Query("select r from ReviewSubject r " +
            "where r.subject.subjectId = :subjectId")
    Page<ReviewSubject> findReviewSubjectById(@Param("subjectId") Long id, Pageable pageable);
}
