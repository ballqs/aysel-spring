package aysel.ayselspring.controller;

import aysel.ayselspring.domain.Member;
import aysel.ayselspring.dto.MemberDto;
import aysel.ayselspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/home")
@Controller
public class HomeController {

    private MemberService memberService;

    @Autowired
    public HomeController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping("")
    public String main(){
        return "home/home";
    }

    @GetMapping("/signup")
    public String signup(){
        return "home/signup";
    }

    @PostMapping("/signup")
    public String create(MemberDto memberDto){
        Member member = new Member();
        member.setName(memberDto.getName());

        memberService.join(member);

        return "redirect:/home";
    }
}
