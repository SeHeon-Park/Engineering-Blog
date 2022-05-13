package jpa.blog.project.Service;

import jpa.blog.project.Entity.Member;
import jpa.blog.project.Entity.MemberContext;
import jpa.blog.project.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)

public class MemberService implements UserDetailsService{
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

    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
        Member member = memberRepository.findByUid(uid)
                .orElseThrow(() -> new UsernameNotFoundException((uid)));
        MemberContext memberContext = new MemberContext(member);
        List<Member> all = findAll();
        System.out.println("입력: "+memberContext.getPassword());
        return memberContext;
    }
}