package au.com.pingmate.controller;

import au.com.pingmate.dao.PlayerDao;
import au.com.pingmate.domain.PingPongPlayer;
import au.com.pingmate.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/*")
public class FooController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(method = RequestMethod.GET)
    public String helloWorld(Model model) {
        //let’s pass some variables to the view script
        model.addAttribute("wisdom", "Goodbye XML");
        PingPongPlayer player = new PingPongPlayer();
        player.setName("Mannan");
        player.setRanking(1000);
        player.setResigned(false);
        playerService.addPlayer(player);
        return "hello"; // renders /WEB-INF/views/hello.jsp
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    @ResponseBody
    public String add() {
        return "add";
    }
}