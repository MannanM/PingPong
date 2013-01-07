package au.com.pingmate.controller;

import au.com.pingmate.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class FooController {

    @Autowired
    Service service;

    @RequestMapping(value = "*", method = RequestMethod.GET)
    @ResponseBody
    public String getAll() {

        return "hi " + service.blah;
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public String add() {
        return "add";
    }
}