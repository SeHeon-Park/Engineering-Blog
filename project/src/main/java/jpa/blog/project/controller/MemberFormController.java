package jpa.blog.project.controller;

import jpa.blog.project.Entity.Member;
import jpa.blog.project.Service.MemberService;
import jpa.blog.project.form.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class MemberFormController {

    private final MemberService memberService;

    @GetMapping(value = "/new")
    public String createMemberForm(Model model) {
        model.addAttribute("memberForm", new MemberForm());
        return "members/createMembers";
    }

    @PostMapping(value = "/new")
    public String createMember(@Valid MemberForm form, Errors errors, Model model) {
        if (errors.hasErrors()){
            model.addAttribute("memberForm", form);
            Map<String, String> validatorResult = memberService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key)); //(오류난 변수 이름, 오류메시지)
            }
            return "members/createMembers";
        }
        if (memberService.checkUidDuplicate(form.getUid())){
            model.addAttribute("memberForm", form);
            model.addAttribute("uidMessage", "중복된 아이디입니다.");
            return "members/createMembers";
        }
        Member member = new Member();
        Member newMember = member.setMember(form.getUid(), form.getUpw(), form.getName(), form.getGrade(), form.getStudentNumber(), form.getMajor());
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

    @GetMapping("/uid/exists")
    public ResponseEntity<Boolean> checkUidDuplicate(MemberForm form){
        System.out.println(form.getUid());
        return ResponseEntity.ok(memberService.checkUidDuplicate(form.getUid()));
    }
}
