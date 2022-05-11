package jpa.blog.project.Service;

import jpa.blog.project.Entity.Member;
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
public class MemberService implements UserDetailsService {
    private final MemberRepository memberRepository;

    @Transactional
    public Long join(Member member){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        member.setUpw(encoder.encode(member.getPassword())); // 암호화
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
    public Member loadUserByUsername(String uid) throws UsernameNotFoundException {
        return memberRepository.findByUid(uid)
                .orElseThrow(() -> new UsernameNotFoundException((uid)));
    }
}