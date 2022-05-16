package spring_hub_mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
        model.addAttribute("allUser",allUsers);
        return "all-users";
    }

    @GetMapping("create")
    public String createUserForm(User user){
        return "user-create";
    }

    @PostMapping("create")
    public String createUser(User user){
        userService.add(user);
        return "redirect:/";
    }

//    @GetMapping("delete/{id}")
//    public String deleteUser(@PathVariable("id") Long id){
//        userService.delete(id);
//        return "redirect:/";
//    }

    @DeleteMapping("delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.delete(id);
        return "redirect:/";
    }

    @GetMapping("{id}")
    public String updateUserForm(@PathVariable("id") Long id,Model model){
        model.addAttribute("user",userService.get(id));
        return "user-update";
    }

//    @PostMapping("update")
//    public String updateUser(User user){
//        userService.update(user);
//        return "redirect:/";
//    }

    @PatchMapping("update")
    public String updateUser(@ModelAttribute("user") User user){
        userService.update(user);
        return "redirect:/";
    }

}
