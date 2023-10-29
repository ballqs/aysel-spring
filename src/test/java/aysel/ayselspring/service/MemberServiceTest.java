package aysel.ayselspring.service;

import aysel.ayselspring.domain.Member;
import aysel.ayselspring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MemberServiceTest {

    @Autowired
    MemberService memberService;

    @Autowired
    MemoryMemberRepository memberRepository;

    @AfterEach //테스트 여러개 돌리면서 충돌날 걸 대비해서 store값을 초기화하는 것
    public void afterEach(){
        memberRepository.clearStore();
    }

    @Test
    void join() {
        //given
        Member member = new Member();
        member.setName("spring");
        //when
        Long saveId = memberService.join(member);

        //then
        Assertions.assertEquals(saveId , member.getId());
    }

    @Test
    void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);

        //then
        IllegalStateException e = Assertions.assertThrows(IllegalStateException.class ,
                                                            () -> memberService.join(member2));
        System.out.println(e.getMessage());

//        try{
//            memberService.join(member2);
//            fail();
//        }catch (IllegalStateException e){
//            System.out.println(e.getMessage());
//        }
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}