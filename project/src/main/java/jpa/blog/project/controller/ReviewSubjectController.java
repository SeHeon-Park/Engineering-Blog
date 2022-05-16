package jpa.blog.project.controller;

import jpa.blog.project.Entity.ReviewSubject;
import jpa.blog.project.Entity.Subject;
import jpa.blog.project.Service.ReviewSubjectService;
import jpa.blog.project.Service.SubjectService;
import jpa.blog.project.form.ReviewSubjectForm;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class ReviewSubjectController {
    private final ReviewSubjectService reviewSubjectService;
    private final SubjectService subjectService;

    @GetMapping("/reviewList/{subjectId}")
    public String showReviewList(@PathVariable("subjectId") Long id, Model model, @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        Subject findSubject = subjectService.findById(id);
        Page<ReviewSubject> reviewSubjects = reviewSubjectService.findReviews(id, pageable);

        model.addAttribute("subjectName", findSubject.getSubjectName());
        model.addAttribute("subjectId", findSubject.getSubjectId());
        model.addAttribute("reviewSubjects", reviewSubjects);

        return "/review/showReviewList";
    }

    @GetMapping("/reviewList/new/{subjectId}")
    public String showCreateReview(@PathVariable("subjectId") Long id, Model model){
        model.addAttribute("reviewSubjectForm", new ReviewSubjectForm());
        model.addAttribute("subjectId", id);
        return "/review/createReview";
    }

    @PostMapping("/reviewList/new/{subjectId}")
    public String createReview(@PathVariable("subjectId") Long id, ReviewSubjectForm form){
        Subject findSubject = subjectService.findById(id);
        ReviewSubject reviewSubject = new ReviewSubject(form.getTitle(), form.getContent());
        reviewSubjectService.addReviewSubject(findSubject, reviewSubject);
        return "redirect:/reviewList/{subjectId}";
    }

    @GetMapping("/review/show/{reviewId}")
    public String showReview(@PathVariable("reviewId") Long reviewId,
                             Model model
    ){
        ReviewSubject findReview = reviewSubjectService.findOne(reviewId);
        Long subjectId = findReview.getSubject().getSubjectId();
        model.addAttribute("reviewForm", new ReviewSubjectForm(findReview.getReviewId(), findReview.getTitle(), findReview.getContent(), findReview.getDay()));
        model.addAttribute("subjectId", subjectId);
        model.addAttribute("reviewId", findReview.getReviewId());
        return "review/showReview";
    }

    @GetMapping("/review/edit/{reviewId}")
    public String editReview(@PathVariable("reviewId") Long reviewId, Model model){
        ReviewSubject findReview = reviewSubjectService.findOne(reviewId);
        model.addAttribute("reviewSubjectForm", new ReviewSubjectForm(findReview.getReviewId(), findReview.getTitle(), findReview.getContent(), findReview.getDay()));
        return "review/editReview";
    }

    @PostMapping("/review/edit/{reviewId}")
    public String editReview(ReviewSubjectForm form){
        Long reviewId = form.getReviewId();
        ReviewSubject findReview = reviewSubjectService.findOne(reviewId);
        findReview.setTitle(form.getTitle());
        findReview.setContent(form.getContent());
        findReview.setDay(LocalDate.now());

        reviewSubjectService.save(findReview);
        return "redirect:/review/show/{reviewId}";
    }

    @PostMapping("/review/delete/{subjectId}/{reviewId}")
    public String deleteReview(@PathVariable("reviewId") Long reviewId,
                               @PathVariable("subjectId") Long subjectId
                               ){
        reviewSubjectService.deleteOne(reviewId);
        return "redirect:/reviewList/{subjectId}";
    }
}
