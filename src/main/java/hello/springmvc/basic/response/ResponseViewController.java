package hello.springmvc.basic.response;


// 1. 정적 리소스
// - /resources/static
// - /resources/public,
// - /resources/META-INF/resources

// 2. 뷰 템플릿 사용(현재 위치)
// - /resources/templates

// 3. JSON 데이터 응답

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1() {
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data", "hello");

        return mav;
    }


    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model) {

        model.addAttribute("data", "hh");
        return "response/hello";
    }


    // 비추
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model) {
        model.addAttribute("data", "hh");
    }


}
