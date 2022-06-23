package jpa.blog.project.controller;

import jpa.blog.project.Entity.Member;
import jpa.blog.project.Entity.ReviewSubject;
import jpa.blog.project.Entity.Subject;
import jpa.blog.project.Service.MemberService;
import jpa.blog.project.form.MemberForm;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final MemberService memberService;

    @RequestMapping("/")
    public String home(Model model, @PageableDefault(page = 0, size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication.getPrincipal().toString() == "anonymousUser"){
            return "/home/home";
        }
        User user = (User) authentication.getPrincipal();
        String uid = user.getUsername();
        Member member = memberService.findOneByUid(uid);

        Map<Subject, Page<ReviewSubject>> reviewSubjects = memberService.findReviewSubjects(member.getMemberId(), pageable);
        model.addAttribute("maps", reviewSubjects);

        MemberForm memberForm = new MemberForm(member.getMemberId(), member.getName());
        model.addAttribute("memberForm", memberForm);
        return "/home/userHome";
    }

    @GetMapping("/formLogin")
    public String loginPage(@RequestParam(value = "error", required = false)String error,
                            @RequestParam(value = "exception", required = false)String exception,
                            Model model){
        model.addAttribute("error", error);
        model.addAttribute("exception", exception);
        return "/home/loginPage";
    }

}
