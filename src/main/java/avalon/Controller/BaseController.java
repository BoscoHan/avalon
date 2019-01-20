package avalon.Controller;

import java.util.concurrent.atomic.AtomicLong;

import avalon.Models.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BaseController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();


    @GetMapping("/hello-world")
    @ResponseBody
    public Users sayHello(@RequestParam(name="name", required=false, defaultValue="Stranger") String name) {
        return new Users(2, name, "Welcome");
    }
}
