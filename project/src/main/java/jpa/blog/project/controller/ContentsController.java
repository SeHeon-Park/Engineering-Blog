package jpa.blog.project.controller;

import jpa.blog.project.Entity.Member;
import jpa.blog.project.Entity.Subject;
import jpa.blog.project.Entity.SubjectWeek;
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
    public String showContent(@ModelAttribute("subjectWeek") SubjectWeek subjectWeek,
                              @PathVariable("id") Long id, Model model){
        Member findMember = memberService.findOneById(id);
        MemberForm memberForm = new MemberForm(findMember.getMemberId(), findMember.getName(), findMember.getGrade(), findMember.getStudentNumber(), findMember.getMajor());
        model.addAttribute("memberForm", memberForm);

        System.out.println(subjectWeek.getWeek());
        List<Subject> findSubject = subjectService.findAllByWeek(subjectWeek);
        List<SubjectForm> subjectForms = findSubject.stream().map(s -> new SubjectForm(s.getWeek(), s.getSubjectName(), s.getCredit())).collect(Collectors.toList());
        model.addAttribute("subjectForms", subjectForms);
        return "contents/showContent";
    }



//    @GetMapping(value = "/orders/show")
//    public String orderList(@ModelAttribute("orderSearch") OrderSearch orderSearch, Model model) {
//        List<Order> orders = orderService.findOrders(orderSearch);
//        model.addAttribute("orders", orders);
//
//
//
//    }
}
