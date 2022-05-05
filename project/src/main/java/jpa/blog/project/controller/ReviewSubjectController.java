package jpa.blog.project.controller;

import jpa.blog.project.Entity.ReviewSubject;
import jpa.blog.project.Entity.Subject;
import jpa.blog.project.Service.ReviewSubjectService;
import jpa.blog.project.Service.SubjectService;
import jpa.blog.project.form.ReviewSubjectForm;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ReviewSubjectController {
    private final ReviewSubjectService reviewSubjectService;
    private final SubjectService subjectService;

    @GetMapping("/reviewList/{subjectId}")
    public String showReviewList(@PathVariable("subjectId") Long id, Model model){
        Subject findSubject = subjectService.findById(id);
        Page<ReviewSubject> reviewSubjects = reviewSubjectService.findReviews(id);

        model.addAttribute("subjectName", findSubject.getSubjectName());
        model.addAttribute("subjectId", findSubject.getSubjectId());

        List<ReviewSubjectForm> reviewSubjectForms = reviewSubjects.stream()
                .map(r -> new ReviewSubjectForm(r.getReviewId(), r.getTitle(), r.getContent()))
                .collect(Collectors.toList());
        model.addAttribute("reviewSubjectForm", reviewSubjectForms);
        return "/review/showReviewList";
    }

    @GetMapping("/reviewList/new/{subjectId}")
    public String showCreateReview(@PathVariable("subjectId") Long id, Model model){
        model.addAttribute("ReviewSubjectForm", new ReviewSubjectForm());
        model.addAttribute("subjectId", id);
        return "/review/createReview";
    }

    @PostMapping("/reviewList/new/{subjectId}")
    public String createReview(@PathVariable("subjectId") Long id, ReviewSubjectForm form){
        Subject findSubject = subjectService.findById(id);
        ReviewSubject reviewSubject = new ReviewSubject(form.getTitle(), form.getContent(), form.getDay());
        reviewSubjectService.addReviewSubject(findSubject, reviewSubject);
        return "redirect:/reviewList/{subjectId}";
    }
}
