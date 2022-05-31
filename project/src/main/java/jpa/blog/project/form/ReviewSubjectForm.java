package jpa.blog.project.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class ReviewSubjectForm {
    private Long reviewId;
    @NotBlank(message = "제목을 입력해 주세요.")
    private String title;
    @Column(columnDefinition = "LONGTEXT")
    private String content;
    private LocalDate day;

    public ReviewSubjectForm(Long reviewId, String title, String content, LocalDate day) {
        this.reviewId = reviewId;
        this.title = title;
        this.content = content;
        this.day = day;
    }
}
