package jpa.blog.project.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Getter @Setter
@NoArgsConstructor
public class ReviewSubject {
    @Id
    @GeneratedValue
    @Column(name = "review_subject_id")
    private Long reviewId;

    private String title;

    @Column(columnDefinition = "LONGTEXT")
    private String content;
    private LocalDate day;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;

    public ReviewSubject(String title, String content) {
        this.title = title;
        this.content = content;
        this.day = LocalDate.now();
    }
}