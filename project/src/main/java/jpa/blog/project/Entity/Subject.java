package jpa.blog.project.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Subject {
    @Id
    @GeneratedValue
    @Column(name = "subject_id")
    private Long subjectId;

    private String week;
    private String subjectName;
    private int credit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @OneToMany(mappedBy = "subject", cascade = CascadeType.ALL)
    private List<ReviewSubject> reviewSubjects = new ArrayList<>();

    public Subject(String week, String subjectName, int credit) {
        this.week = week;
        this.subjectName = subjectName;
        this.credit = credit;
    }

    public Subject(String subjectName) {
        this.subjectName = subjectName;
    }

    public Long getMemberId(){
        return this.getMember().getMemberId();
    }

    public void addReviewSubject(ReviewSubject reviewSubject){
        reviewSubjects.add(reviewSubject);
        reviewSubject.setSubject(this);
    }
}