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
    Page<ReviewSubject> findReviewSubjectByIdTen(@Param("subjectId") Long id, Pageable pageable);

    @Query("select r from ReviewSubject r " +
            "where r.subject.subjectId = :subjectId")
    Page<ReviewSubject> findReviewSubjectByIdTwo(@Param("subjectId") Long id, Pageable pageable);

    ReviewSubject findReviewSubjectByReviewId(Long reviewId);

    void deleteReviewSubjectByReviewId(Long id);

    @Query("select r from ReviewSubject r " +
            "where r.subject.subjectId = :subjectId")
    List<ReviewSubject> findReviewSubjectBySubjectId(@Param("subjectId") Long id);
}
