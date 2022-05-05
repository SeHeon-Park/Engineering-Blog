package jpa.blog.project.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class SubjectForm {
    private Long subjectId;
    private String week;
    private String subjectName;
    private int credit;

    public SubjectForm(Long subjectId, String week, String subjectName, int credit) {
        this.subjectId = subjectId;
        this.week = week;
        this.subjectName = subjectName;
        this.credit = credit;
    }
}
