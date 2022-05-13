package jpa.blog.project.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@NoArgsConstructor
public class MemberForm {

    private Long memberId;
    @NotNull(message = "아이디를 입력해 주세요!")
    private String uid;
    @NotNull(message = "비밀번호를 입력해 주세요!")
    private String upw;
    @NotNull(message = "이름을 입력해 주세요!")
    private String name;
    private int grade;
    @NotNull(message = "학번을 입력해 주세요!")
    private String studentNumber;
    @NotNull(message = "전공을 입력해 주세요")
    private String major;

    public MemberForm(Long memberId, String name, int grade, String studentNumber, String major) {
        this.memberId = memberId;
        this.name = name;
        this.grade = grade;
        this.studentNumber = studentNumber;
        this.major = major;
    }
}
