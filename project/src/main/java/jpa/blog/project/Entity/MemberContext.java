package jpa.blog.project.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Getter
public class MemberContext extends User {

    private final Member member;

    public MemberContext(Member member) {
        super(member.getUid(), member.getUpw(), getAuthorities(member.getRoles()));
        System.out.println("객체안: " + member.getUpw());
        this.member = member;
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(List<Role> role) {
        return Collections.singleton(new SimpleGrantedAuthority(role.get(0).getRoleName()));
    }

}
