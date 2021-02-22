package com.MyPage.MyPage.Controllers;

import com.MyPage.MyPage.Models.User;
import com.MyPage.MyPage.Repositories.UserRepository;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class StarterController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public String getStartingPage(){
        return "index";
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";
    }

    @GetMapping("/register")
    public String showRegisterForm(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/registerProcces")
    public String succededRegistration(User user, Model model){
        if (userRepository.findByEmail(user.getEmail()) == null){
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String encodePassword = encoder.encode(user.getPassword());
            user.setPassword(encodePassword);
            userRepository.save(user);
            return "succededRegistration";
        }
        else {
            String exist = "The email is already used.";
            model.addAttribute("exist", exist);
            return "register";
        }

    }


    @GetMapping("/error")
    public String errorPage(){
        return "error";
    }
}
