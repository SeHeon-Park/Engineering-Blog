package jpa.blog.project.Service;

import jpa.blog.project.Entity.Member;
import jpa.blog.project.Entity.MemberContext;
import jpa.blog.project.Entity.ReviewSubject;
import jpa.blog.project.Entity.Subject;
import jpa.blog.project.repository.MemberRepository;
import jpa.blog.project.repository.ReviewSubjectRepository;
import jpa.blog.project.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MemberService implements UserDetailsService{
    private final MemberRepository memberRepository;
    private final SubjectRepository subjectRepository;
    private final ReviewSubjectRepository reviewSubjectRepository;

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

    public Member findOneByUid(String uid){
        Member member = memberRepository.findByUid(uid)
                .orElseThrow(() -> new UsernameNotFoundException((uid)));
        return member;
    }

    public Map<Subject, Page<ReviewSubject>> findReviewSubjects(Long memberId, Pageable pageable){
        List<Subject> subjects = subjectRepository.findSubjectsByMemberId(memberId);
        Map<Subject, Page<ReviewSubject>> map = new HashMap<>();
        for (Subject s : subjects){
            map.put(s, reviewSubjectRepository.findReviewSubjectByIdTwo(s.getSubjectId(), pageable));
        }
        return map;
    }

    @Override
    public UserDetails loadUserByUsername(String uid) throws UsernameNotFoundException {
        Member member = memberRepository.findByUid(uid)
                .orElseThrow(() -> new UsernameNotFoundException((uid)));
        MemberContext memberContext = new MemberContext(member);
        return memberContext;
    }

    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();
        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }
        return validatorResult;
    }

    public boolean checkUidDuplicate(String uid){
        return memberRepository.existsByUid(uid);
    }
}