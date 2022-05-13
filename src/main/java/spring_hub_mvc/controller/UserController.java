package spring_hub_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import spring_hub_mvc.model.User;
import spring_hub_mvc.service.UserService;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public String showAllEmployee(Model model){
        List<User> allUsers = userService.getAllUsers();
        model.addAttribute("user",allUsers);
        return "all-users";
    }
}
