package au.com.pingmate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/*")
public class FooController {

    @RequestMapping(method = RequestMethod.GET)
    public String helloWorld(Model model) {
        //let’s pass some variables to the view script
        model.addAttribute("wisdom", "Goodbye XML");

        return "hello"; // renders /WEB-INF/views/hello.jsp
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public String add() {
        return "add";
    }
}