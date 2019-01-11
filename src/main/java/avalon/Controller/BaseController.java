package avalon.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BaseController {

    @RequestMapping("/home")
    public String test() {
        return"welcome";
    }
}
