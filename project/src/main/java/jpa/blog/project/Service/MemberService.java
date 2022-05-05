package jpa.blog.project.Service;

import jpa.blog.project.Entity.Member;
import jpa.blog.project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member){
        memberRepository.save(member);
        return member.getMemberId();
    }

    public List<Member> findAll(){
        return memberRepository.findAll();
    }

    public Member findOneBySubjectId(Long id){
        return memberRepository.findMemberByMemberId(id);
    }

    @Transactional
    public void deleteMember(Long memberId) {
        memberRepository.deleteById(memberId);
    }
}