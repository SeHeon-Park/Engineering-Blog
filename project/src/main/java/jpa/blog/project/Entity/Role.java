package jpa.blog.project.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Role {
    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Long roleId;

    private String roleName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;
}
