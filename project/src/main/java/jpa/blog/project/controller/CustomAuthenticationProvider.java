package jpa.blog.project.controller;

import jpa.blog.project.Entity.Member;
import jpa.blog.project.Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;

public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Autowired
    private MemberService memberService;

    @Autowired private BCryptPasswordEncoder passwordEncoder;

    @Override public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = (String) authentication.getCredentials();
        Member member = null;
        Collection<GrantedAuthority> authorities = null;
        try {
            UserDetails userDetails = memberService.loadUserByUsername(username);
            // 이용자가 로그인 폼에서 입력한 비밀번호와 DB로부터 가져온 암호화된 비밀번호를 비교한다
            if (!passwordEncoder.matches(password, userDetails.getPassword()))
                throw new BadCredentialsException("비밀번호 불일치");
            authorities = (Collection<GrantedAuthority>) userDetails.getAuthorities();
        } catch(UsernameNotFoundException e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        } catch(BadCredentialsException e) {
            e.printStackTrace();
            throw new BadCredentialsException(e.getMessage());
        } catch(Exception e) { e.printStackTrace();
            throw new RuntimeException(e.getMessage()); }

        return new UsernamePasswordAuthenticationToken(username, password, authorities);
    }

    @Override public boolean supports(Class<?> arg0) {
        return true;
    }
}
