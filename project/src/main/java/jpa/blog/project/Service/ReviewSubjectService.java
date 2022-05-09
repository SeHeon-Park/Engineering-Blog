package jpa.blog.project.Service;

import jpa.blog.project.Entity.ReviewSubject;
import jpa.blog.project.Entity.Subject;
import jpa.blog.project.repository.ReviewSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ReviewSubjectService {
    private final ReviewSubjectRepository reviewSubjectRepository;

    @Transactional
    public void save(ReviewSubject reviewSubject){
        reviewSubjectRepository.save(reviewSubject);
    }

    @Transactional
    public void addReviewSubject(Subject subject, ReviewSubject reviewSubject){
        subject.addReviewSubject(reviewSubject);
        reviewSubjectRepository.save(reviewSubject);
    }

    public List<ReviewSubject> findAll(){
        return reviewSubjectRepository.findAll();
    }

    public Page<ReviewSubject> findReviews(Long id, Pageable pageable){
        return reviewSubjectRepository.findReviewSubjectById(id, pageable);
    }

    public ReviewSubject findOne(Long reviewId){
        return reviewSubjectRepository.findReviewSubjectByReviewId(reviewId);
    }

    @Transactional
    public void deleteOne(Long reviewId){
        reviewSubjectRepository.deleteReviewSubjectByReviewId(reviewId);
    }
}
