package co.nz.kdg.postform.web;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class HelloController {

    // Define GET Request
    @RequestMapping(value = "/basic", method = RequestMethod.GET)
    public String sayHello() {
        return "Hello there";
    }


    // By Default GET Request
    @RequestMapping("/proper")
    public String sayProperHello() {
        return "Hello there, Have a good day...";
    }


    // Post Form
    @RequestMapping("/user_entry")
    public String userEntry() {
        return "<form action=\"/greeting/user_entry_greeting\" method=\"POST\">\n" +
                "  <label for=\"fname\">First name:</label><br>\n" +
                "  <input type=\"text\" id=\"fname\" name=\"fname\" placeholder=\"First Name\"><br>\n" +
                "  <label for=\"lname\">Last name:</label><br>\n" +
                "  <input type=\"text\" id=\"lname\" name=\"lname\" placeholder=\"Last Name\"><br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form> ";
    }


    @RequestMapping(value = "/user_entry_greeting", method = RequestMethod.POST)
    public String userEntryGreeting(@RequestParam String fname, @RequestParam String lname) {
        return "Hi, " + fname + " " + lname;
    }


    // Pass Form Data as Query Parameters
    @RequestMapping("/user_form")
    public String userForm() {
        return "<form action=\"/greeting/user_form_greeting\" method=\"GET\">\n" +
                "  <label for=\"fname\">First name:</label><br>\n" +
                "  <input type=\"text\" id=\"fname\" name=\"fname\" placeholder=\"First Name\"><br>\n" +
                "  <label for=\"lname\">Last name:</label><br>\n" +
                "  <input type=\"text\" id=\"lname\" name=\"lname\" placeholder=\"Last Name\"><br><br>\n" +
                "  <input type=\"submit\" value=\"Submit\">\n" +
                "</form> ";
    }


    @RequestMapping("/user_form_greeting")
    public String userFormGreeting(@RequestParam String fname, @RequestParam String lname) {
        return "Hi, " + fname + " " + lname;
    }


    // Path Variables --> /orders/100
    @RequestMapping(value = "/orders/{id}", method = RequestMethod.GET)
    public String getOrder(@PathVariable String id) {
        return "Your Order ID : " + id;
    }
}
