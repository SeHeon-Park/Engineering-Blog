package jpa.blog.project.controller;

import jpa.blog.project.Entity.Member;
import jpa.blog.project.Entity.SearchSubject;
import jpa.blog.project.Entity.Subject;
import jpa.blog.project.Service.MemberService;
import jpa.blog.project.Service.SubjectService;
import jpa.blog.project.form.SubjectForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class SubjectController {
    private final SubjectService subjectService;
    private final MemberService memberService;

    @GetMapping("/subject/new/{memberId}")
    public String createSubjectForm(@PathVariable("memberId") Long memberId, Model model){
        model.addAttribute("subjectForm", new SubjectForm());
        model.addAttribute("memberId", memberId);
        return "/subjects/createSubjects";
    }

    @PostMapping("/subject/new/{memberId}")
    public String createSubject(@PathVariable("memberId") Long memberId, SubjectForm subjectForm){
        System.out.println(memberId);
        Member findMember = memberService.findOneBySubjectId(memberId);
        Subject subject = new Subject(subjectForm.getWeek(), subjectForm.getSubjectName(), subjectForm.getCredit());
        subjectService.addSubject(findMember, subject);
        return "redirect:/subject/show/{memberId}";
    }

    @GetMapping("/subject/show/{id}")
    public String showSubjects(@ModelAttribute("searchSubject") SearchSubject searchSubject,
                               @PathVariable("id") Long id, Model model){
        List<Subject> findSubject = subjectService.findAllByInput(searchSubject, id);
        List<SubjectForm> subjectForms = findSubject.stream().map(s -> new SubjectForm(s.getSubjectId(), s.getWeek(), s.getSubjectName(), s.getCredit())).collect(Collectors.toList());
        model.addAttribute("memberId", id);
        model.addAttribute("subjectForms", subjectForms);

        String subjectName = searchSubject.getSubjectName();
        String week = searchSubject.getWeek();
        model.addAttribute("subjectName", subjectName);
        model.addAttribute("week", week);
        return "/subjects/showSubjectList";
    }

    @PostMapping("/subject/delete/{subjectId}/{memberId}")
    public String deleteSubject(@PathVariable("subjectId") Long subjectId,
                                @PathVariable("memberId") Long memberId)
                        {

        subjectService.delete(subjectId);
        return "redirect:/subject/show/{memberId}";
    }

}
