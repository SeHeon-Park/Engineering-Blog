package jpa.blog.project;

import jpa.blog.project.Service.MemberService;
import jpa.blog.project.controller.CustomAuthFailureHandler;
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

    private final CustomAuthFailureHandler customFailureHandler;


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
                    .antMatchers("/", "/formLogin", "/new", "/uid/**").permitAll() // 누구나 접근 허용
//                    .antMatchers("/members/**", "/subject/**", "/review/**", "/reviewList/**").hasAnyRole("USER")
//                    .antMatchers("/members").hasAnyRole("ADMIN") // ADMIN만 접근 가능
                    .anyRequest().authenticated() // 나머지 요청들은 권한의 종류에 상관 없이 권한이 있어야 접근 가능
                .and()
                    .formLogin()
                    .loginPage("/formLogin") // 로그인 페이지 링크
                    .loginProcessingUrl("/login_proc")
                    .defaultSuccessUrl("/", true) // 로그인 성공 후 리다이렉트 주소
                    .failureHandler(customFailureHandler)
                .and()
                    .logout()
                    .logoutSuccessUrl("/")
                    .invalidateHttpSession(true) // 세션 날리기
        ;
    }

}