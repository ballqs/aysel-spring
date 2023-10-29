package aysel.ayselspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@RequestMapping("/hello")
@Controller
public class HelloController {

    //Mapping에 빈값으로 처리하면 @RequestMapping("/hello")에 따라 hello로 만으로 여기 접근 가능
    @GetMapping("")
    public String Hello(Model model){
        model.addAttribute("data" , "hello");
        return "hello/hello";
    }

    @GetMapping("hello-mvc")
    public String helloMVC(@RequestParam(value = "name" , required = false) String name , Model model){
        model.addAttribute("name" , name);
        return "hello/hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody
    public String helloString(@RequestParam("name") String name){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    static class Hello {
        private String name;

        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }
    }
}
