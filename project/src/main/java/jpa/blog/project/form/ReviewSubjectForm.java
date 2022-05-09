package jpa.blog.project.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ReviewSubjectForm {
    private Long reviewId;
    private String title;
    private String content;
    private LocalDate day;

    public ReviewSubjectForm(Long reviewId, String title, String content, LocalDate day) {
        this.reviewId = reviewId;
        this.title = title;
        this.content = content;
        this.day = day;
    }
}
