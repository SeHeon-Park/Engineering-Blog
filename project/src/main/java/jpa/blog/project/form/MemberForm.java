package jpa.blog.project.form;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Getter
@Setter
@NoArgsConstructor
public class MemberForm {

    private Long memberId;
    @NotBlank(message = "아이디는 필수 입력 값 입니다.")
    private String uid;

    @NotBlank(message = "비밀번호는 필수 입력 값 입니다.")
    @Pattern(regexp = "(?=.*[0-9])(?=.*[a-zA-Z])(?=.*\\W)(?=\\S+$).{8,16}", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String upw;

    @NotBlank(message = "이름은 필수 입력 값 입니다.")
    private String name;

    private int grade;

    private String studentNumber;

    private String major;

    public MemberForm(Long memberId, String name, int grade, String studentNumber, String major) {
        this.memberId = memberId;
        this.name = name;
        this.grade = grade;
        this.studentNumber = studentNumber;
        this.major = major;
    }

    public MemberForm(Long memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }
}
