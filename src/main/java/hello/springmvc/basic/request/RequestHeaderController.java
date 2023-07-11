package hello.springmvc.basic.request;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;
import java.util.Map;

@Slf4j
@RestController
public class RequestHeaderController {


    @RequestMapping("/headers")
    public String header(HttpServletRequest request,
                        HttpServletResponse response,
                        HttpMethod httpMethod,
                        Locale locale,
                        @RequestHeader Map<String, String> headerMap,
                         @RequestHeader MultiValueMap<String, String> MultiHeaderMap,
                        @RequestHeader("host") String host,
                        @CookieValue(value = "myCookie", required = false) String cookie
                        ) {


        // MultiValueMap 키로 뽑아내면 배열로 반환 됨, 같은 키에 여러 값이 있을 때
        log.info("request={}", request);
        log.info("response={}", response);
        log.info("httpMethod={}", httpMethod);
        log.info("locale={}", locale);
        log.info("headerMap={}", headerMap);
        log.info("MultiHeaderMap={}", MultiHeaderMap);
        log.info("host={}", host);
        log.info("cookie={}", cookie);

        return "ok";
    }
}
