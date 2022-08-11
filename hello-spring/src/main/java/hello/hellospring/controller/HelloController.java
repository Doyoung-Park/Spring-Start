package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

    @GetMapping("hello") // 웹에서 /hello 로 접근하면 이 메서드를 호출해준다.
    public String hello(Model model){ // 여기서 Model 은 MVC 에서의 Model 이 맞음
        model.addAttribute("data","박도영 입니다!"); // data 라는 key에 "박도영 입니다!" 라는 데이터를 넣음
        return "hello";     // templates 디렉토리에 있는 hello.html 을 실행시켜라(렌더링 해라) 라는 뜻
    }

    @GetMapping("hello-mvc")
    public String helloMve(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template"; // hello-template.html 을 실행시킴.
    }

    @GetMapping("hello-string")
    @ResponseBody   // http 에서 body 부분에 이 내용을 직접 넣어주겠다는 의미.
    public String helloString(@RequestParam("name") String name) {
        return "hello "+ name;
    }

    @GetMapping("hello-api") // 데이터를 내놓으라는 싱황. api 방식. json 방식
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;   // 객체를 넘김
    }

    static class Hello{
        private String name;

        public String getName(){ //게터세터-> 자바 빈 표준 방식, 프로퍼티 접근 방식 이라고 함
            return name;
        }
        public void setName(String name){
            this.name=name;
        }

    }

}
