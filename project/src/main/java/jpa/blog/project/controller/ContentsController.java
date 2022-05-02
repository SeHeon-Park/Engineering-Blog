package jpa.blog.project.controller;

import jpa.blog.project.Entity.Member;
import jpa.blog.project.Entity.Subject;
import jpa.blog.project.Entity.SearchSubject;
import jpa.blog.project.Service.MemberService;
import jpa.blog.project.Service.SubjectService;
import jpa.blog.project.form.MemberForm;
import jpa.blog.project.form.SubjectForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ContentsController {

    private final MemberService memberService;
    private final SubjectService subjectService;


    @GetMapping("/contents/show/{id}")
    public String showContent(@ModelAttribute("searchSubject") SearchSubject searchSubject,
                              @PathVariable("id") Long id, Model model){
        System.out.println(searchSubject.getWeek());
        List<Subject> findSubject = subjectService.findAllByInput(searchSubject, id);
        List<SubjectForm> subjectForms = findSubject.stream().map(s -> new SubjectForm(s.getWeek(), s.getSubjectName(), s.getCredit())).collect(Collectors.toList());
        model.addAttribute("subjectForms", subjectForms);
        return "contents/showContent";
    }

}
