package jpa.blog.project.controller;

import jpa.blog.project.Entity.Member;
import jpa.blog.project.Service.MemberService;
import jpa.blog.project.form.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Controller
@RequiredArgsConstructor
public class MemberFormController {

    private final MemberService memberService;

    @GetMapping(value = "/members/new")
    public String createMemberForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMembers";
    }

    @PostMapping(value = "/members/new")
    public String createMember(MemberForm form) {
        Member member = new Member();
        Member newMember = member.setMember(form.getName(), form.getGrade(), form.getStudentNumber(), form.getMajor());
        memberService.join(newMember);
        return "redirect:/";
    }

    @GetMapping("/members")
    public String showMembers(Model model) {
        List<Member> members = memberService.findAll();
        List<MemberForm> memberForms = members.stream()
                .map(m -> new MemberForm(m.getMemberId(), m.getName(), m.getGrade(), m.getStudentNumber(), m.getMajor()))
                .collect(Collectors.toList());
        model.addAttribute("memberForms", memberForms);
        return "members/showMembers";
    }

    @PostMapping("/members/{memberId}/delete")
    public String deleteMember(@PathVariable("memberId") Long memberId) {
        memberService.deleteMember(memberId);
        return "redirect:/members";
    }
}