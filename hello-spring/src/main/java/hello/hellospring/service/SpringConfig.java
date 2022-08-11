package hello.hellospring.service;

import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean // Serive를 스프링빈에 등록을 함 (자바코드로)
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean // Repository를 스프링빈에 등록함. (자바코드로)
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }

}
