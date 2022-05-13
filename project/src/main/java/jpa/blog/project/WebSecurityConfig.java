package jpa.blog.project;

import jpa.blog.project.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@RequiredArgsConstructor
@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final MemberService memberService;
    private final AuthenticationFailureHandler customFailureHandler;


    @Override
    public void configure(WebSecurity web) {
        web.ignoring().antMatchers("/css/**", "/script/**", "image/**", "/fonts/**", "lib/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf()
                .disable()
                .authorizeRequests()
//                .antMatchers("/formLogin", "/members/new", "/members").permitAll() // 누구나 접근 허용
                .antMatchers("/**").permitAll()
//                .antMatchers("/admin/**").hasRole("ADMIN")
//                .antMatchers("/").hasRole("USER") // USER, ADMIN만 접근 가능
//                .antMatchers("/admin").hasRole("ADMIN") // ADMIN만 접근 가능
//                .anyRequest().authenticated() // 나머지 요청들은 권한의 종류에 상관 없이 권한이 있어야 접근 가능
                .and()
                .formLogin()
                .loginPage("/formLogin") // 로그인 페이지 링크
                .loginProcessingUrl("/login_proc")
                .defaultSuccessUrl("/", true) // 로그인 성공 후 리다이렉트 주소
                .failureUrl("/formLogin")
                .failureHandler(customFailureHandler)
                .and()
                .logout();
//                .invalidateHttpSession(true) // 세션 날리기
        ;
    }

}