package jpa.blog.project.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.persistence.*;
import java.util.*;

@Entity
@Getter @Setter
@NoArgsConstructor
//implements UserDetails
public class Member {
    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long memberId;

    @Column(nullable = false,  length=50)
    private String uid;

    @Column(nullable = false, length=200)
    private String upw;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Role> roles = new ArrayList<>();

    private String name;
    private int grade;
    private String studentNumber;
    private String major;

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private List<Subject> subjects = new ArrayList<>();

    public Subject addSubject(Subject subject){
        subject.setMember(this);
        this.subjects.add(subject);
        return subject;
    }

    public Member(String name, String major) {
        this.name = name;
        this.major = major;
    }

    public Member setMember(String uid, String upw, String name, int grade, String studentNumber, String major){
        Role role = new Role();
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.uid = uid;
        this.upw =  "{bcrypt}"+passwordEncoder.encode(upw);
        role.setRoleName("BASIC");
        role.setMember(this);
        this.roles.add(role);
        this.name = name;
        this.grade = grade;
        this.studentNumber = studentNumber;
        this.major = major;

        return this;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        Set<GrantedAuthority> roles = new HashSet<>();
//        for (String role : auth.split(",")) {
//            roles.add(new SimpleGrantedAuthority(role));
//        }
//        return roles;
//    }
//
//    @Override
//    public String getPassword() {
//        return upw;
//    }
//
//    @Override
//    public String getUsername() {
//        return name;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}