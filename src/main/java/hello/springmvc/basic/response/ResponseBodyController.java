package hello.springmvc.basic.response;


import hello.springmvc.basic.HelloData;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;


// 1. 정적 리소스
// - /resources/static
// - /resources/public,
// - /resources/META-INF/resources

// 2. 뷰 템플릿 사용
// - /resources/templates

// 3. JSON 데이터 응답(현재 위치)

@Slf4j
@Controller
public class ResponseBodyController
{
    @GetMapping("/response-body-string-v1")
    public void responseBodyV1(HttpServletResponse response) throws IOException {
        response.getWriter().write("ok");
    }

    @GetMapping("/response-body-string-v2")
    public ResponseEntity<String> responseBodyV2() {
        return new ResponseEntity<>("ok", HttpStatus.OK);
    }


    @GetMapping("/response-body-string-v3")
    public String responseBodyV3() {
        return "ok";
    }

    @GetMapping("/response-body-json-v1")
    public ResponseEntity<HelloData> responseJsonV1() {

        HelloData helloData = new HelloData();
        helloData.setAge(20);
        helloData.setUsername("asd");

        return new ResponseEntity<>(helloData, HttpStatus.OK);
    }



    @ResponseStatus(HttpStatus.OK) // 동적으로 하려면 위에꺼 ResponseEntity 로 해야함
    @ResponseBody
    @GetMapping("/response-body-json-v2")
    public HelloData responseJsonV2() {

        HelloData helloData = new HelloData();
        helloData.setAge(20);
        helloData.setUsername("asd");

        return helloData;
    }







}
