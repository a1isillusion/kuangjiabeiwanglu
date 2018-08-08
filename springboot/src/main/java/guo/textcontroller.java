package guo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class textcontroller {
    @GetMapping("/helloworld")
    public String helloworld() {
     
    	return "helloworld";
    }
}
