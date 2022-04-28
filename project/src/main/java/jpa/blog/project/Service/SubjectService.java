package jpa.blog.project.Service;

import jpa.blog.project.Entity.Member;
import jpa.blog.project.Entity.Subject;
import jpa.blog.project.repository.SubjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class SubjectService {

    private final SubjectRepository subjectRepository;

    @Transactional
    public void save(Subject subject){
        subjectRepository.save(subject);
    }

    public List<Subject> findSubject(Long memberId){
        return subjectRepository.findSubjectsByMemberId(memberId);
    }

    public List<Subject> findAll(){
        return subjectRepository.findAll();
    }

    @Transactional
    public void addSubject(Member member, Subject subject){
        member.addSubject(subject);
        subjectRepository.save(subject);
    }


}