package jpa.blog.project.Service;

import jpa.blog.project.Entity.Member;
import jpa.blog.project.Entity.ReviewSubject;
import jpa.blog.project.Entity.Subject;
import jpa.blog.project.repository.ReviewSubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();
        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            System.out.println(validKeyName);
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }

    public ReviewSubject findPrevOne(ReviewSubject review, Long subjectId){
        List<ReviewSubject> reviews = reviewSubjectRepository.findReviewSubjectBySubjectId(subjectId);
        int index = reviews.indexOf(review);
        if(index == 0) {
            return null;
        }
        return reviews.get(index-1);
    }

    public List<ReviewSubject> findReviewSubjectBySubjectId(Long subjectId){
        return reviewSubjectRepository.findReviewSubjectBySubjectId(subjectId);
    }

}
