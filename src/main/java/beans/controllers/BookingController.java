package beans.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

@Controller
public class BookingController {

    @RequestMapping(value = "/booking", method = RequestMethod.GET)
    public ModelAndView helloWorld() {

        String message = "helloWorld";
        return new ModelAndView("welcome", "message", message);
    }

}
