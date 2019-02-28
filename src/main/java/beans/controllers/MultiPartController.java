package beans.controllers;

import beans.models.User;
import beans.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class MultiPartController {

    private UserService userService;

    @Autowired
    public MultiPartController(UserService userService) {
        this.userService = userService;
    }


    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    public String getTicketsForEvent(@RequestParam("users") MultipartFile[] files) throws IOException {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("ticketsPdf");

        ObjectMapper mapper = new ObjectMapper();
        mapper.findAndRegisterModules();

        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                User user = mapper.readValue(file.getBytes(), User.class);
                userService.register(user);
            }
        }
        return "uploadFinished";
    }

}

