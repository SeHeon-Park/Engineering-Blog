package jpa.blog.project.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long memberId;

    private String name;
    private int grade;
    private String studentNumber;
    private String major;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Subject> subjects = new ArrayList<>();

    public Subject addSubject(Subject subject){
        subject.setMember(this);
        this.subjects.add(subject);
        return subject;
    }

    public Member(String name, String major) {
        this.name = name;
        this.major = major;
    }

    public Member setMember(String name, int grade, String studentNumber, String major){
        this.name = name;
        this.grade = grade;
        this.studentNumber = studentNumber;
        this.major = major;
        return this;
    }
}