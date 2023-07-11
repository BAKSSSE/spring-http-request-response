package hello.springmvc.basic.request;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.IOException;
import java.io.InputStream;
import java.io.Writer;
import java.nio.charset.StandardCharsets;

@Slf4j
@Controller
public class RequestBodyStringController {


    // JSON으로 올땐 stream으로 바이트 코드로 읽어야한다.
    // 1. http 컨버터를 사용해 직접 stream사용을 하지 않아도 됨
    // httpentity 는 http의 해더와 바디를 조회 하는 기능
    // 응답에도 사용가능하다. 메세지 바디에 직접 반환, 해더 정보 ㅂ포함 가능, view 조회 안함
    // 2. @RequestBody 애노테이션으로 대체 가능


    //--------------------------
    // 요청 파라메터 vs http 메세지 바디(JSON)
    // 요청 파라메터 조회: @RequestParam @ModelAttribute 모델에 바로 적용
    // http 메세지 조회: @RequestBody

    @PostMapping("/request-body-string-v1")
    public void requestBodyString(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ServletInputStream inputStream = request.getInputStream(); //스트림은 바이트코드라서 문자셋을 지정해줘야한다.
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("body={}", messageBody);

        response.getWriter().write("ok");
    }

    @PostMapping("/request-body-string-v2")
    public void requestBodyStringV2(InputStream inputStream, Writer responseWriter) throws IOException {
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);

        log.info("body={}", messageBody);
        responseWriter.write("ok");
    }

    @PostMapping("/request-body-string-v3")
    public HttpEntity<String> requestBodyStringV3(HttpEntity<String> httpEntity) throws IOException {
        // RequestEntity 대체가
//        RequestEntity
        String messageBody = httpEntity.getBody();
        log.info("body={}", messageBody);


//        return new HttpEntity<>("OK");
        // ResponseEntity 대체 가능
        return new ResponseEntity<>("OK", HttpStatus.CREATED);
    }


    @ResponseBody
    @PostMapping("/request-body-string-v4")
    public String requestBodyStringV4(@RequestBody String messageBody) throws IOException {
        log.info("body={}", messageBody);

        return "OK";
    }

}
