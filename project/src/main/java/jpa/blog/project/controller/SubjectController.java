package jpa.blog.project.controller;

import jpa.blog.project.Entity.Member;
import jpa.blog.project.Entity.Subject;
import jpa.blog.project.Service.MemberService;
import jpa.blog.project.Service.SubjectService;
import jpa.blog.project.form.SubjectForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;
    private final MemberService memberService;

    @GetMapping("/subject/new/{memberId}")
    public String createSubjectForm(@PathVariable("memberId") Long memberId, Model model){
        model.addAttribute("subjectForm", new SubjectForm());
        model.addAttribute("memberId", memberId);
        return "subjects/createSubjects";
    }

    @PostMapping("/subject/new/{memberId}")
    public String createSubject(@PathVariable("memberId") Long memberId, SubjectForm subjectForm){
        System.out.println(memberId);
        Member findMember = memberService.findOneBySubjectId(memberId);
        Subject subject = new Subject(subjectForm.getWeek(), subjectForm.getSubjectName(), subjectForm.getCredit());
        subjectService.addSubject(findMember, subject);
        return "redirect:/contents/show/{memberId}";
    }

}
