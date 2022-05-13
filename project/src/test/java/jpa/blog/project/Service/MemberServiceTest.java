package jpa.blog.project.Service;

import jpa.blog.project.Entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Rollback(value = false)
class MemberServiceTest {

    @Autowired MemberService memberService;

    @Test
    public void joinTest(){
        Member member = new Member();
        member.setMember("qtwe153", "sonamu0928*", "박세헌", 4, "201701433", "컴퓨터");
        memberService.join(member);
    }
}