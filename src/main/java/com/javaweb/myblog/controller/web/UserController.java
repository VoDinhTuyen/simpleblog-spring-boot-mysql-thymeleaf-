package com.javaweb.myblog.controller.web;

import com.javaweb.myblog.model.UserModel;
import com.javaweb.myblog.service.IUserService;
import com.javaweb.myblog.service.impl.UserService;
import com.javaweb.myblog.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private UserValidator userValidator;

    @GetMapping(value = {"/registration"})
    public String registrationPage(Model model) {
        model.addAttribute("userModel", new UserModel());
        return "registration";
    }

    @PostMapping(value = {"/registration"})
    public String registration(@ModelAttribute("userModel") UserModel userModel, BindingResult bindingResult) {
        userValidator.validate(userModel, bindingResult);
        if(bindingResult.hasErrors()) {
            return "registration";
        }
        userService.save(userModel);
        return "redirect:/home";
    }

    @GetMapping(value = {"/login"})
    public String loginPage() {
        return "login";
    }

    @GetMapping(value = {"/logout"})
    public String logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null) {
            new SecurityContextLogoutHandler().logout(request, response, authentication);
        }
        return "redirect:/home";
    }

    @GetMapping(value = {"/403"})
    public String accessDeniedPage() {
        return "403";
    }
}
