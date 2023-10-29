package aysel.ayselspring;

import aysel.ayselspring.repository.MemberRepository;
import aysel.ayselspring.repository.MemoryMemberRepository;
import aysel.ayselspring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService(){
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository(){
        return new MemoryMemberRepository();
    }
}
