package co.nz.kdg.helloworld.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/greeting")
public class GreetingsController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String greetings() {
        return "<h1>Hello there... How are you...</h1>";
    }
}
