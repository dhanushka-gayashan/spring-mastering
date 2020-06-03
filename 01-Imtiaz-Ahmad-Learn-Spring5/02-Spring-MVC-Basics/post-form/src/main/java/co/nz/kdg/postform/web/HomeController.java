package co.nz.kdg.postform.web;

import co.nz.kdg.postform.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class HomeController {

    @RequestMapping("/")
    public String home(Model model) {
        // Send this object along with the index.html
        model.addAttribute("formData", new User());
        //Redirect to index.html page at resources/templates/index.html
        return "index";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String processFormData(User user, RedirectAttributes attributes) {
        // Form data coming along with user object
        // Execute Store Data Functions
        attributes.addFlashAttribute("user", user);
        // Send data to redirect URL
        return "redirect:/display";
    }

    @RequestMapping(value = "/display", method = RequestMethod.GET)
    public String displayFormData(User user) {
        // User object automatically bind into the result.html
        //Redirect to index.html page at resources/templates/result.html
        return "result";
    }
}
