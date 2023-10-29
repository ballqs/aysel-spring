package aysel.ayselspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class AyselSpringApplication {
    //접근된 URL에 매핑되는 컨트롤이 없을 경우 해당 URL를 기반으로 resources/static에서 파일 찾음
    public static void main(String[] args) {
        SpringApplication.run(AyselSpringApplication.class, args);
    }

}
