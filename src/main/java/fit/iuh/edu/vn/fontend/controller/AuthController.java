package fit.iuh.edu.vn.fontend.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthController {

    @GetMapping("/login")
    public String loginPage() {
        return "login"; // Trả về template login.html
    }

    @GetMapping("/")
    public String homePage() {
        return "index"; // Trả về template home.html
    }
}
