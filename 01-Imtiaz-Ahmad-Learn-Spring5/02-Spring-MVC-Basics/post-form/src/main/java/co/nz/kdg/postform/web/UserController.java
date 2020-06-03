package co.nz.kdg.postform.web;

import co.nz.kdg.postform.domain.Product;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/{userId}")
    public String displayUser(@PathVariable int userId) {
        return "User Found: " + userId;
    }


    // Pass Query Parameter --> /user/100/invoices?date=10/02/2020
    @RequestMapping("/{userId}/invoices")
    public String displayUserInvoice(@PathVariable int userId, @RequestParam Date date) {
        return "Invoice found for user: " + userId + " on " + date;
    }


    // Pass Query Parameter --> /user/100/invoices?d=10/02/2020 --> Date is optional
    @RequestMapping("/{id}/bills")
    public String displayUserBill(
            @PathVariable("id") int userId,
            @RequestParam(value = "d", required = false) Date dateOrNull
    ) {
        return "Bill found for user: " + userId + " on " + dateOrNull;
    }


    // Return JSON String Array
    @RequestMapping("/{userId}/items")
    public List<String> getItems() {
        return Arrays.asList("Laptop", "Mouse", "Keyboard");
    }


    // Return JSON Objects Array
    @RequestMapping("/{userId}/products")
    public List<Product> getProducts() {
        return Arrays.asList(
                new Product(1, "Laptop", 100),
                new Product(2, "Mouse", 200),
                new Product(3, "Keyboard", 300)
        );
    }
}
