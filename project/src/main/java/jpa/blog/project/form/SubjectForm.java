package jpa.blog.project.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class SubjectForm {
    private String week;
    private String subjectName;
    private int credit;

    public SubjectForm(String week, String subjectName, int credit) {
        this.subjectName = subjectName;
        this.credit = credit;
    }
}
