//package jpa.blog.project.api;
//
//import jpa.blog.project.Entity.Member;
//import jpa.blog.project.Service.MemberService;
//import jpa.blog.project.form.MemberForm;
//import lombok.Data;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Controller;
//import org.springframework.stereotype.Repository;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.annotation.WebServlet;
//import javax.validation.Valid;
//
//
///** api개발 코드 **/
//@RestController
//@RequiredArgsConstructor
//public class MemberController {
//
//    private final MemberService memberService;
//
//    @PostMapping(value = "api/members/new")
//    public ResponseMember createMember(@RequestBody @Valid RequestMember requestMember){
//        Member member = new Member();
//        Member newMember = member.setMember(requestMember.name, requestMember.grade, requestMember.studentNumber, requestMember.major);
//        memberService.join(newMember);
//        return new ResponseMember(newMember.getMemberId());
//    }
//
//    @Data
//    static class RequestMember{
//        private String name;
//        private int grade;
//        private String studentNumber;
//        private String major;
//    }
//
//    @Data
//    static class ResponseMember{
//        private Long id;
//
//        public ResponseMember(Long id) {
//            this.id = id;
//        }
//    }
//}
