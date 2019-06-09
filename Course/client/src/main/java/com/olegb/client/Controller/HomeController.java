package com.olegb.client.Controller;

import com.olegb.client.Model.Role;
import com.olegb.client.Model.User;
import com.olegb.client.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collections;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping
    public String indexPage(){

        return "index.jsp";
    }
    @GetMapping("/main")
    public String mainPage(){
        return "main.jsp";
    }
    @GetMapping("/login")
    public String login(Model model, String error) {
        if (error != null)
            model.addAttribute("error", "Your username or password are invalid.");
        return "login.jsp";
    }
    @GetMapping("/registration")
    public String registration(){
        return "registration.jsp";
    }
    @PostMapping("/registration")
    public String addNewUser(User user, Model model, @RequestParam("role") String role){
        User userFromDb =  userRepository.findByUsername(user.getUsername());

        if(userFromDb!=null){
            model.addAttribute("message","User exists!");
            return "registration.jsp";
        }else if(!user.getPassword().isEmpty()&(!user.getUsername().isEmpty())){
            user.setActive(true);
            if(role.equals("User"))
                user.setRoles(Collections.singleton(Role.USER));
            else
                user.setRoles(Collections.singleton(Role.COACH));
            userRepository.save(user);
        }
        return "redirect:/login";
    }

}
