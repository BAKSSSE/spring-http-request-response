package hello.springmvc.basic;


import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class LogTestController {

    //    private final Logger log = LoggerFactory.getLogger(getClass()); // Slf4j lombok 애노테이션 사용

    @RequestMapping("/log-test")
    public String logTest() {
        String name = "asd";
        log.trace("trace={}", name);
        log.debug("debug={}", name);
        log.info("info={}", name);
        log.warn("warn={}", name);
        log.error("error={}", name);
        return "ok";
    }
}
